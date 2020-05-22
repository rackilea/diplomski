import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


@SuppressLint("ShowToast")
public class ListMain extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ListView mylist = (ListView) findViewById(R.id.companionsearch_listView1);
        String[] list={"one","two","three"};
        ArrayAdapter adapter = new ArrayAdapter<String>(ListMain.this,android.R.layout.simple_list_item_multiple_choice,list);
        mylist.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        mylist.setAdapter(adapter);

    }
}