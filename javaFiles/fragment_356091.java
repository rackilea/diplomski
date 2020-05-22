import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Utils.createDir(Environment.getExternalStorageDirectory().toString(),"Downloads");
                Utils.createDir(Environment.getExternalStorageDirectory().toString()+"/Downloads", "Files");

                String unzipLocation = Environment.getExternalStorageDirectory() +"/"+"Downloads"+"/"+"Files"+"/";
                String zipFile =Environment.getExternalStorageDirectory() +"/"+"Downloads"+"/"+"Files"+"."+"zip";
                String url="https://eventfo.com.au/index.php/userapi/api/eventdetaildownload/eventid/162/accesskey/534ccbcc10ab2/deviceId/85d2a504b2be7af4/deviceType/Android";
                try {
                    new Utils().downloadEventData(MainActivity.this,zipFile, unzipLocation, url);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}