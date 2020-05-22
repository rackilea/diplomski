class Base { 
  void intercepted() { ... }
}

class BaseImpl extends Base { 
  void doSomething() { ... }
}

class BaseImpl$$cglib extends BaseImpl { 
  @Override void intercepted() { ... }
}