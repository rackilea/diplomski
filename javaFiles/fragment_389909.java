public class MainActivity extends Activity {

    //onclick function...
    myDataSource = (DataSource)getApplicationContext();
    myDataSource.beginDataLoad(MainActivity.this);

    //Callback for AsyncTask to call when its completed
    public void dataIsLoaded() {
        //Do stuff once data has been loaded
    }
}