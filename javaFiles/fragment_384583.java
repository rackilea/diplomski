class Foo {
  private Bar myBar;
  ...
  public Foo shallowCopy() {
    Foo newFoo = new Foo();
    newFoo.myBar = myBar;
    return newFoo;
  }

  public Foo deepCopy() {
    Foo newFoo = new Foo();
    newFoo.myBar = myBar.clone(); //or new Bar(myBar) or myBar.deepCopy or ...
    return newFoo;
  }
}

Foo myFoo = new Foo();  
Foo sFoo = myFoo.shallowCopy();  
Foo dFoo = myFoo.deepCopy();  

myFoo.myBar == sFoo.myBar => true  
myFoo.myBar.equals(sFoo.myBar) => true  
myFoo.myBar == dFoo.myBar => **false**  
myFoo.myBar.equals(dFoo.myBar) => true