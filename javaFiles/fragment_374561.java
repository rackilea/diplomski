export class ExampleComponent {
    loading: boolean = false;
     @ViewChild('exampleForm') exampleForm: NgForm;

     canDeactivate(): Observable<boolean> | boolean {

        if (this.loading|| this.exampleForm.dirty) {

           return this.confirmBox('Discard Unsaved Changes?');
       }
       return true;
     }

    confirmBox(message?: string): Observable<boolean> {
       const confirmation = window.confirm(message || 'Are you sure?');

       return of(confirmation);
   };


}