public class FragmentReminder extends Activity implements View.OnClickListener {

    private ArrayList al;
    private List list = new ArrayList();
    private ArrayAdapter<String> adapter;
    ListView lv;
    TextView tv;
    FloatingActionButton fab;

    public void receiveData(ArrayList al) {
        this.al = al;
        list.add(al.get(0));

    }


    //data for customlist
    private String desc[] = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reminder);

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        lv = (ListView) findViewById(R.id.rem_lv);
        tv = (TextView) findViewById(R.id.reminder_tv);

        fab.setOnClickListener(this);
        DatabaseHandler db = new DatabaseHandler(this);
        list = db.getAllReminders();

        if (list.size() == 0) {
            lv.setVisibility(GONE);
        }

        tv.setVisibility(GONE);

        adapter = new CustomList(this, list, desc);
        lv.setAdapter(adapter);

        //***Customised list view add***********************************************************************
       /* CustomList customList = new CustomList(getActivity(),list, desc);
        lv.setAdapter(customList);*/

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getActivity(),"You Clicked "+list.get(i),Toast.LENGTH_SHORT).show();
                //addReminderInCalendar();
                Intent in = new Intent(FragmentReminder.this, MedRemInfo.class);
                in.putExtra("id", list.get(i).toString());
                startActivity(in);
            }
        });

    }


    @Override
    public void onClick(View v) {
        Intent in = new Intent(this, AddReminder.class);
        startActivity(in);
    }

}