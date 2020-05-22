public class MainActivity1 extends Activity {

    String[] wordlist = new String[] { "a", "b", "c" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView list = new ListView(this);
        list.setAdapter(new MyAdapter(this, wordlist));

        setContentView(list);
    }

    private class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(Context context, String[] strings) {
            super(context, -1, -1, strings);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LinearLayout listLayout = new LinearLayout(MainActivity1.this);
            listLayout.setLayoutParams(new AbsListView.LayoutParams(
                    AbsListView.LayoutParams.WRAP_CONTENT,
                    AbsListView.LayoutParams.WRAP_CONTENT));
            listLayout.setId(5000);

            TextView listText = new TextView(MainActivity1.this);
            listText.setId(5001);

            listLayout.addView(listText);

        listText.setText(super.getItem(position));

            return listLayout;
        }
    }
}