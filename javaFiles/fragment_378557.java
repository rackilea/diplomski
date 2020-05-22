public void doSomething(Class<? extends myClass1> cls) 
{
    try {
      cls.newInstance().printStuff();
    } catch (InstantiationException e) {
      ....
    } catch (IllegalAccessException e) {
      ....
    }
}