import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.example.BDDRequest.Callback;

public class MainActivity extends FragmentActivity implements Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BDDRequest.GetRequest(this, new UserEmployeeInfo(), this);


    }

    @Override
    public void onSuccess(String response) {
        // Bind the data to the listview
    }

    @Override
    public void onError() {
        //Show fallback message here
    }
}