public class Counter
{
  private int count;
  private int stepValue;

  public Counter () { //no argument constructor - must be explictly made now
    count=0;
    stepValue = 1;
  }

  public Counter (int initCount, int value)
  {       
    count=initCount;
    stepValue=value;
  }  

  //rest of code
}