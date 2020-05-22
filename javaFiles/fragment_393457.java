public class IdGenerator{
  private String value;

  public IdGenerator( String initial value ){
    this.value = value;
  }

  public synchronized String nextValue(){
    value = incrementValue( value );
    return value;
  }

  private static String nextValue( String currentValue ){
    // Somehow increment the value.
    return incrementedValue;
  }

}