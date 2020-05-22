package my.package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity {

    private TextView Latit;
    private TextView Longit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Latit = (TextView)findViewById(R.id.tvLatitude);
        Longit = (TextView)findViewById(R.id.tvLongitude);

        //Presume you are using an XML based OnClick

    }

    public void goDirect(View v){
        Intent passData = new Intent(getApplicationContext(), testDataPass.class);
        passData.putExtra("Latitude",Latit.getText().toString());
        passData.putExtra("Longitude", Longit.getText().toString());
        startActivity(passData);
    }

}