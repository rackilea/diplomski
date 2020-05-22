import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
   private baseUrl = 'http://localhost:8084/login';
   private apiUrl = '/api/employees';

  constructor(private http:HttpClient) { }

  checkUsers()
  {
    return this.http.get(this.baseUrl);
  }
  ...
}