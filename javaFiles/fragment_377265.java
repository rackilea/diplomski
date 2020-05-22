public class MyActivity extends Activity implements LocationListener{

    @Override
    public void onResume(){
        geoLocation.addListener(this);
    }

    @Override     
    public void onPause(){
        geoLocation.removeListener(this);
    }

    @Override
    public void onLocationChanged(Location newLocation) {

    }

}