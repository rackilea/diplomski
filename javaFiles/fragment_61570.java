public class MainActivity extends Activity {
/** Called when the activity is first created. */
Button btn;
static int count = 0;
private ListView list;
public static ArrayList<String> values = new ArrayList<String>();;
ArrayList<Integer> countList = new ArrayList<Integer>();
private ArrayAdapter<String> adapter;
SharedPreferences shared;
Editor editor;
private static ArrayList<String> sharedList = new ArrayList<String>();

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    list = (ListView) findViewById(R.id.list);
    btn = (Button) findViewById(R.id.btn);
    shared = this.getSharedPreferences("Myprefernces",
            Context.MODE_WORLD_WRITEABLE);
    editor = shared.edit();

    sharedList.clear();
    int size = shared.getInt("SIZE", 0);
    count = size;
    for (int k = 0; k < size; k++) {
        sharedList.add(shared.getString("addr" + k, ""));
    }
    adapter = new ArrayAdapter<String>(MainActivity.this,
            android.R.layout.simple_list_item_1, sharedList);
    list.setAdapter(adapter);

    btn.setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            count++;

            if (count > 5) {
                --count;
                Toast.makeText(getApplicationContext(), "" + count, 100)
                        .show();
            } else {
                String string = "one";
                if (count == 1) {
                    values.add("one");
                    countList.add(count);
                    string = "one";
                }
                if (count == 2) {
                    values.add("two");
                    countList.add(count);
                    string = "two";
                }
                if (count == 3) {
                    values.add("three");
                    countList.add(count);
                    string = "three";
                }
                if (count == 4) {
                    values.add("four");
                    countList.add(count);
                    string = "four";

                }
                if (count == 5) {
                    values.add("five");
                    countList.add(count);
                    string = "five";
                }

                // put values to sharedpreferences
                // editor.putInt("SIZE", values.size());
                editor.putInt("SIZE", count);

                editor.putString("addr" + (count - 1), string);
                // for (int i = 0; i < values.size(); i++) {
                // editor.putString("addr" + count, values.get(i));
                // }
                editor.commit();
                // getting values from sharedpreference

                sharedList.clear();

                int size = shared.getInt("SIZE", 0);
                for (int k = 0; k < size; k++) {
                    sharedList.add(shared.getString("addr" + k, ""));
                }
                adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, sharedList);
                list.setAdapter(adapter);
            }

        }
    });
    list.setOnItemLongClickListener(new OnItemLongClickListener() {

        public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                int arg2, long arg3) {
            // TODO Auto-generated method stub
            --count;
            // values.remove(arg2);
            sharedList.remove(arg2);
            editor.clear();
            editor.commit();
            editor.putInt("SIZE", sharedList.size());
            for (int i = 0; i < sharedList.size(); i++) {
                editor.putString("addr" + i, sharedList.get(i));
            }
            editor.commit();
            adapter.notifyDataSetChanged();

            return true;
        }
    });

}
}