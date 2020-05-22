@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    //Initialize Interface
    Model.LoadModel();
    listView = (ListView) findViewById(R.id.listView);
    String[] ids = new String[Model.Items.size()];
    for (int i= 0; i < ids.length; i++)
    {ids[i] = Integer.toString(i+1);}
    // change following line:
    this.adapter = new ItemAdapter(this,R.layout.row, ids);