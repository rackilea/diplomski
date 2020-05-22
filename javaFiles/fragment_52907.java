protected void onCreate(Bundle savedInstancesState)
{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras1 = getIntent().getExtras();
        if (extras1 != null) {
            var2 = extras1.getString("key1");
        }
    public void backButton(View view) 
{
        Intent intent2= new Intent(this,MainActivity.class);
        intent2.putExtra("key2",var2);
        startActivity(intent2);
    }
}