@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        gridView=(GridView) findViewById(R.id.gridView);

        gridView.setAdapter(new MoverAdapter(this));

        gridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                    long id) {
                // TODO Auto-generated method stub

                Intent i = new Intent(SelectCategory.this, description_class.class);
                i.putExtra("id", position);
                startActivity(i);

            //  Toast.makeText(context1, "YEs", Toast.LENGTH_SHORT).show();

            }
        });

    }