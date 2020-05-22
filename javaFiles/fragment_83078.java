import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class TimeService extends Service {

   CountDownTimer cdt = null;
   private SharedPreferences pref;
   //Things you want SharedPreferences to change.
   Intent i;

   @Override
   public void onCreate() {
       i = new Intent(this, TimeService.class);
       startService(i);
       pref = this.getSharedPreferences("myAppPref", MODE_PRIVATE);
       cdt = new CountDownTimer(3600000, 1000) { //One hour timer with one second interval.

           @Override
           public void onTick(long millisUntilFinished) {

           }

           @Override
           public void onFinish() {
                //Whatever you need SharedPreferences to change here.
           }
       };
       cdt.start();
   }

   @Nullable
   @Override
   public IBinder onBind(Intent intent) {
       return null;
   }
}