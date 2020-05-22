void runner(){
  DaggerInjectorComponent comp = DaggerInjectorComponent.builder....
  comp.InjectorModule(new InjectorModule(...)); 
  comp.inject(this) //HERE YOU CREATE AND INJECT YOUR DEPENDENCY
  comp.inject(this) // HERE NOTHING WILL HAPPEN, AS DEPENDENCY IS CACHED
}