import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;

public class Hotels extends AppCompatActivity {
    ServiceManager service=new ServiceManager(getApplicationContext());
    Hotel hotels[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
        GridLayout glHotels=(GridLayout) findViewById(R.id.glHotels);

        Thread getHotels=new Thread(new Runnable() {
            @Override
            public void run() {
                hotels=service.GetHotels(1);
            }
        });
        getHotels.start();
        for (int i=0; i<hotels.length; i++) {
            glHotels.addView(hotels[i]);
        }
    }
}