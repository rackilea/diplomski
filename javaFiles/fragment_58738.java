import { Component, NgZone, OnInit, OnDestroy } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Subscription } from 'rxjs/Subscription';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {
  event: Observable<MyEvent>;
  private _eventSource: EventSource;
  private _events: BehaviorSubject<MyEvent> = new BehaviorSubject<MyEvent>(null);
  constructor(private _http: Http, private _zone: NgZone) {}
  ngOnInit() {
    this._eventSource = this.createEventSource();
    this.event = this.createEventObservable();
  }

  private createEventObservable(): Observable<MyEvent> {
    return this._events.asObservable();
  }

  private createEventSource(): EventSource {
      const eventSource = new EventSource('http://localhost:8080/events');
      eventSource.onmessage = sse => {
        const event: MyEvent = new MyEvent(JSON.parse(sse.data));
        this._zone.run(()=>this._events.next(event));
      };
      eventSource.onerror = err => this._events.error(err);
      return eventSource;
  }
}