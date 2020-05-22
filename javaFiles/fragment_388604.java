interface IsInterface {
 @Inject
 void init(InjectorA a, InjectorB b, ...);
}

public ConcreteClassA implements IsInterface {

 InjectorA a, InjectorB c, InjectorC c;
 ConcreteClassA() {}
 @Override
 public void init(InjectorA a, InjectorB b, ..) {
  this.a = a;
  this.b = b;
  ....
 }

}