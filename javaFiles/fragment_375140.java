class Parent
{
  ... stuff
}

class Child extends Parent
{
  Parent newParent1()
  {
    return this;
  }

  Parent newParent2()
  {
    return new Child();
  }

  Parent newParent3()
  {
    return new Parent();
  }