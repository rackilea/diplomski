import {Http} from '@angular/http'

class Picker {
  constructor(private http:Http) {
    document.getElementByID('date-picker')
      .addEventListener('date-picker-event-or-whatever', date => this.send(date));
  }

  send(date) {
    this.http
      .post('some/rest/api', JSON.stringify(date))
      .map(reposne => response.json())
      .subscribe(json => console.log(json));
  }
}