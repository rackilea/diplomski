@NgModule({
  imports: [
    RouterModule.forRoot([
      { 
      path: 'example', 
      canDeactivate: [DeactivateGuardService],
      component: ExampleComponent 
    }
    ])
  ]