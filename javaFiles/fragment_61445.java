import { Component, OnInit } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Observable } from 'rxjs/Observable';
@Component({
  selector: 'app-root',
  template: '<h1>Dukes</h1>',
  // templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'here beta';
  dukes = [{ name: "offline", age: 2 }];
      data = "data=\"{title: 'foo',body: 'bar',userId: 1};\"";
  headers: Headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded' });
  options: RequestOptions = new RequestOptions({ headers: this.headers });
  constructor(private http: Http) { }

  ngOnInit() {
    let options = new RequestOptions();
    options.headers = new Headers();
    options.headers.append('Content-Type', 'application/x-www-form-urlencoded');
    const req = this.http.post('http://localhost:8080/SampleProject/getTutorial', this.data, options)
      .subscribe(
      res => {
        console.log(res);
      },
      err => {
        console.log("Error occured");
      }
      );