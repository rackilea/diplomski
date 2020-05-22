public class MyClass {
  //Useless because you are only using a static field of this class.
  //private LocationManager locationManager;

  //Static attributes must be named with UPPER CASE letters
  private static Location MY_LOCATION;

  private static Location getBestLocation() {

  private static Location getLocationByProvider(String provider) {
    ...
  }

  public static String getCity(){
    ...
  }
}