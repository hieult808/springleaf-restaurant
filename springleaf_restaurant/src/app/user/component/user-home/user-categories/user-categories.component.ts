import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Category } from 'src/app/interface/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-user-categories',
  templateUrl: './user-categories.component.html',
  styleUrls: ['./user-categories.component.css']
})
export class UserCategoriesComponent {

  categories: Category[] = [];

  constructor(private categoriesService: CategoryService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    console.log("Init category component");
    this.getCategories();
  }

  getCategories(): void {
    this.categoriesService.getCategories()
      .subscribe(categories => this.categories = categories);
  }

}
