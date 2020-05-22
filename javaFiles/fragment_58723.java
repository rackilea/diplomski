interface IA
{
  public void someFunction();
}


class B implements IA
{
  public void someFunction()
  {
    //busy code block
  }
  public void someBfunc()
  {
     //doing b things
  }
}


class C implements IA
{
  public void someFunction()
  {
    //busy code block
  }
  public void someCfunc()
  {
     //doing C things
  }
}

class MyRunner
{
     @Autowire
     @Qualifier("b") 
     IA worker;

     ....
     worker.someFunction();
}