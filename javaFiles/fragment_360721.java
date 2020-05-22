import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.util.List;


public class MainActivity extends AppCompatActivity implements AsyncCallWS.OnTaskCompleteCallback {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  AsyncCallWS callWS = new AsyncCallWS(this);
  callWS.execute("some_params");
 }

 @Override
 public void dataReady(@NonNull List < String > data) {
  //here you can set data in adapter
 }
}