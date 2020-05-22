public enum BooleanEnum
{  
  False(0), True(1);    

  private final int value;

  static
  {
    BooleanEnum[] arrayOfBooleanEnum = new BooleanEnum[2];
    arrayOfBooleanEnum[0] = False;
    arrayOfBooleanEnum[1] = True;
  }

  private BooleanEnum(int arg3)
  {
    this.value = arg3;
  }

  public int getValue()
  {
    return this.value;
  }
}