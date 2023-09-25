import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AdminHomeComponent } from './admin/component/admin-home/admin-home.component';
import { UserHomeComponent } from './user/component/user-home/user-home.component';
import { UserCartComponent } from './user/component/user-home/user-cart/user-cart.component';
import { UserHeaderComponent } from './user/component/user-home/user-header/user-header.component';
import { UserProductsComponent } from './user/component/user-home/user-products/user-products.component';
import { UserProductDetailComponent } from './user/component/user-home/user-product-detail/user-product-detail.component';
import { AdminHeaderComponent } from './admin/component/admin-home/admin-header/admin-header.component';
import { AdminProductsComponent } from './admin/component/admin-home/admin-products/admin-products.component';
import { AdminProductDetailComponent } from './admin/component/admin-home/admin-product-detail/admin-product-detail.component';
import { ChatComponent } from './component/chat/chat.component';
import { WebSocketService } from './service/web-socket.service';
import { ChatService } from './service/chat.service';
import { LoginComponent } from './component/login/login.component';
import { UserIndexComponent } from './user/component/user-home/user-index/user-index.component';
import { UserFooterComponent } from './user/component/user-home/user-footer/user-footer.component';
import { AdminUserComponent } from './admin/component/admin-home/admin-user/admin-user.component';
import { AdminIndexComponent } from './admin/component/admin-home/admin-index/admin-index.component';
import { AdminFooterComponent } from './admin/component/admin-home/admin-footer/admin-footer.component';
import { UserCategoriesComponent } from './user/component/user-home/user-categories/user-categories.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    UserHomeComponent,
    UserCartComponent,
    UserHeaderComponent,
    UserProductsComponent,
    UserProductDetailComponent,
    AdminHeaderComponent,
    AdminProductsComponent,
    AdminProductDetailComponent,
    AdminUserComponent,
    AdminIndexComponent,
    AdminFooterComponent,
    ChatComponent,
    LoginComponent,
    UserIndexComponent,
    UserFooterComponent,
    UserCategoriesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [
    WebSocketService,
    ChatService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
