public class ListViewDemo extends ListActivity {
private TextView selection;
private String root;
private List<String> item = null;
private List<String> path = null;

@Override
public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.main);

    // This is the part I added.
    File sdCard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
    File dir = new File(sdCard.getPath() + "/hvac/");

    if (dir.exists()) {
        root = new String(String.valueOf(dir));
    }
    else {
        dir.mkdir();
        root = new String(String.valueOf(dir));
    }

    item = new ArrayList<String>();
    path = new ArrayList<String>();
    File f = new File(String.valueOf(root));
    final File[] files = f.listFiles();

    if (files != null) {

        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (!file.isHidden() && file.canRead()) {
                path.add(file.getPath());
                if (file.isDirectory()) {
                    item.add(file.getName() + "/");

                }
                else {
                    item.add(file.getName());
                }
            }

        }

    }
    else {
        Toast.makeText(this, "No Files", Toast.LENGTH_LONG).show();
    }

    setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item));
    selection = (TextView) findViewById(R.id.selection);

}

@Override
public void onListItemClick(ListView parent, View v, int position,
                            long id) {
    selection.setText(item.get(position));
}
}