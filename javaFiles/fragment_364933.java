void runner(){
  DaggerInjectorComponent comp = DaggerInjectorComponent.builder....
  comp.InjectorModule(new InjectorModule(...)); 
  comp.inject(this) //HERE YOU CREATE AND INJECT YOUR DEPENDENCY

  comp = null
  comp = DaggerInjectorComponent.builder.... // component is recreated
  comp.InjectorModule(new InjectorModule(...)); 
  comp.inject(this) // HERE YOUR DEPENDECY IS REINITIALIZED, COMPLETELY NEW OBJECT
}