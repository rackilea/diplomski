import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class MainActivity extends AppCompatActivity {


    ArrayList<Item> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList.clear();

        Item item = new Item(1, "UserName 1");

        arrayList.add(item);

        for (int i = 0; i < 3; i++) {
            Item item2 = new Item(2, "UserName 2");
            arrayList.add(item2);

        }

        Item item3 = new Item(3, "UserName 3");
        arrayList.add(item3);


        Item item4 = new Item(4, "UserName4");
        arrayList.add(item4);

        Item item5 = new Item(5, "UserName 5");
        arrayList.add(item5);


        Set<Item> s = new HashSet<Item>();
        s.addAll(arrayList);
        arrayList = new ArrayList<Item>();
        arrayList.addAll(s);

        for (int i=0;i<arrayList.size();i++){
            if (arrayList.get(i).getId() == 2) {
                arrayList.remove(i);
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            Log.e("ID      :", arrayList.get(i).getId() + "");
            Log.e("UserName:", arrayList.get(i).getUsername() + "");
        }
    }


}