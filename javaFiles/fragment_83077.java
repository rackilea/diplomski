import android.content.Intent;
import android.support.v4.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
       Intent i;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           i = new Intent(this, TimeService.class);

           stopService(i); //To stop the service the next time the app is launched.
       }

       @Override
       protected void onDestroy() {
           launchService(); //Launches the service once when app shuts down.
           super.onDestroy();
       }

       public void launchService() { //How to launch the service, depending the phone's API.
            if(Build.VERSION.SDK_INT >= 26) {
                 startForegroundService(new Intent(this, TimeService.class));
            }
            else{
                Intent i;
                i = new Intent(this, TimeService.class);
                ContextCompat.startForegroundService(this, i);
            }
       }
}