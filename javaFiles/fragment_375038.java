private ListView listView;
private MyListAdapter adapter;

public class MainActivity extends Activity{

     @Override
     public void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         listView = (ListView) findViewById(android.R.id.list);
         ...
     }

     ...
}