public class DataHolder{
  private static String dataString;
  public static String getDataString(){
    synchronized(DataHolder.class){
      return DataHolder.dataString;
    }
  }

  public static void setString(String dataString){
    synchronized(DataHolder.class){
      DataHolder.dataString = dataString;
    }
  }
}