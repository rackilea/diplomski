public class MediaPlay extends BaseActivity {

    MediaPlayer mp;
    Uri uri;

    ListView listView;
    TextView textBilgi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        Field[] fields = R.raw.class.getFields();
        final String[] mediaList = new String[fields.length];
        for (int count = 0; count < fields.length; count++)
            mediaList[count] = fields[count].getName();


        textBilgi = (TextView) findViewById(R.id.textBilgi1);
        listView = (ListView) findViewById(R.id.listview);

        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("Test One");
        your_array_list.add("Test Two");
        your_array_list.add("Test Three");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MediaPlay.this, android.R.layout.simple_list_item_1,
                your_array_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String uri = "android.resource://" + getPackageName() + "/raw/" + mediaList[position];


                if (mp != null && mp.isPlaying())
                    mp.stop();

                mp = MediaPlayer.create(getApplicationContext(), Uri.parse(uri));
                mp.start();

                textBilgi.setText(((TextView) view).getText() + " ["
                        + mp.getDuration() / 1000 + " sn.]");


            }
        });

    }
}