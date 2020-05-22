import java.util.ArrayList;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void popUp(View v){

        // Dummy list:
        ArrayList<String> dummies = new ArrayList<String>();

        dummies.add("dumm1");
        dummies.add("dumm2");
        dummies.add("dumm3");
        dummies.add("dumm4");
        dummies.add("dumm5");

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.list_layout);
        dialog.setTitle("List Title");
        ListView listView = (ListView) dialog.findViewById(R.id.list);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.single_item_layout , R.id.singleItem, dummies);
        listView.setAdapter(ad);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //do something on click
                dialog.dismiss();
            }
        });

        dialog.show();
    }   
}