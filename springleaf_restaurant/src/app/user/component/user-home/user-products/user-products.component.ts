import { Product } from './../../../interface/products';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ProductService } from 'src/app/user/service/products.service';

@Component({
  selector: 'app-user-products',
  templateUrl: './user-products.component.html',
  styleUrls: ['./user-products.component.css']
})
export class UserProductsComponent {

  products: Product[] = [];

  constructor(private productsService: ProductService) {
  }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productsService.getProducts()
      .subscribe(categories => this.products = categories);
  }

  

}
