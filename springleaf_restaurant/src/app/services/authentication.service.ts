import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private apiUrl = 'http://localhost:8080/api/v1/auth'; // Thay thế bằng URL của Spring Boot API
  private userCache: User | null = null;
  private cachedDataSubject = new BehaviorSubject<User | null>(null);

  constructor(private http: HttpClient) {}

  // Đây là một observable để theo dõi sự thay đổi trong userCache
  cachedData$: Observable<User | null> = this.cachedDataSubject.asObservable();

  setUserCache(user: User | null) {
    this.userCache = user;
    this.cachedDataSubject.next(user); // Thông báo cho bất kỳ thành phần nào đang theo dõi userCache
  }

  register(username: string, password: string): Observable<any> {
    const registerData = {
      username: username,
      password: password,
      roleId: 1
    };

    return this.http.post(`${this.apiUrl}/register`, registerData);
  }

  login(username: string, password: string): Observable<any> {
    const loginData = {
      userName: username,
      password: password
    };

    return this.http.post(`${this.apiUrl}/authenticate`, loginData);
  }

  refreshToken(refreshToken: string): Observable<any> {
    const tokenData = {
      refreshToken: refreshToken
    };

    return this.http.post(`${this.apiUrl}/refreshToken`, tokenData);
  }

  logout() {
    // Xóa token JWT khỏi lưu trữ khi đăng xuất
    localStorage.removeItem('jwtToken');
    this.setUserCache(null); // Xóa dữ liệu người dùng khỏi userCache
  }

  getToken(): string | null {
    // Lấy token JWT từ lưu trữ
    return localStorage.getItem('jwtToken');
  }

  getUserCache(): User | null {
    return this.userCache;
  }
}
