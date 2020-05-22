import {HashLocationStrategy, LocationStrategy} from "@angular/common";

@NgModule({
  declarations: [
   ...
  ],
  imports: [
...
  ],
  providers: [
...
    {provide: LocationStrategy, useClass: HashLocationStrategy},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}