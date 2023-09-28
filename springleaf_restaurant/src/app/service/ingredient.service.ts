
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ApiService } from 'src/app/service/api.service';
import { Ingredient } from '../interface/ingredient';


@Injectable({
    providedIn: 'root'
})
export class IngredientService {
    [x: string]: any;

    private IngredientsUrl = 'ingredient'; // URL to web api, không cần thêm base URL
    ingredientsCache: Ingredient[] | null = null; // Cache for categories

    constructor(private apiService: ApiService) { } // Inject ApiService

    // Sử dụng ApiService để gửi yêu cầu GET
    getIngredients(): Observable<Ingredient[]> {
        // Kiểm tra nếu có dữ liệu trong cache, trả về dữ liệu đó
        if (this.ingredientsCache) {
            return of(this.ingredientsCache);
        }

        const ingredientsObservable = this.apiService.request<Ingredient[]>('get', this.IngredientsUrl);

        // Cache the categories observable
        ingredientsObservable.subscribe(data => {
            this.ingredientsCache = data; // Store the fetched data in the cache
        });

        return ingredientsObservable;
    }



}