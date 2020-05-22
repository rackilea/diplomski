Set<MyClass> doSomething(Set<MyClass> oldSet) {

  Set<MyClass> newSet =oldSet.getClass().newInstance();

  return newSet;
}