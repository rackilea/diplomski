public enum EventAction 
{
  SDCARD_MOUNTED
  {
    @Override
    public String toString() {
      return "External SDCard was mounted";
    }
    @Override
    public int getCode() {
      return 25;
    }
  };

  public abstract int getCode();

}