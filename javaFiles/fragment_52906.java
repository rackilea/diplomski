protected void onCreate(Bundle savedInstancesState)
{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            pengar = extras.getString("key2");
        }
}
 public void nextActivity(View view) 
{
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key1",pengar);
        startActivity(intent);
}