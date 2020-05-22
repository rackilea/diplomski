class ThisClass
{
  private Counter counter;

  private ThisClass() { counter = new Counter(); }

  public static Counter count(Object parent) 
  {
    ThisClass thisClass = new ThisClass();
    thisClass.count2(parent);
    return thisClass.counter;
  }

  private void count2(Object parent)
    ...
}