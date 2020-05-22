public class MainActivity extends Activity {
  private Geocoder mGeocoder;

  @Override
  protected void onCreate(Bundle _icicle) {
    super.onCreate(_icicle);
    mGeocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
  }
}