interface IA
{
  public void someFunction();
}

@Component(value="b")
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


@Component(value="c")
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

@Component    
class MyRunner
{
     @Autowire
     @Qualifier("b") 
     IA worker;

     ....
     worker.someFunction();
}