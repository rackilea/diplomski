export class MyEvent {
  id: number;
  when: any;

  constructor(jsonData) {
    Object.assign(this, jsonData);
  }
}