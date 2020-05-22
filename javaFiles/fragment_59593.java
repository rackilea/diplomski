private LinearLayout myLayout;

protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.something);

    myLayout = (LinearLayout) findViewById(R.id.my_layout);
    createBtns( loadFirstCategory() );
}

private void createBtns(Category c)
{
    List<Category> c_list = c.getCategoryList();
    for (int i=0; i<c_list.size(); i++)
    {
        Button btn = new Button(this);
        btn.setText( c_list.get(i).getName() );
        myLayout.addView(btn);

        btn.setOnClickListener(new OnClickListener() {
            public void onClick()
            {
                myLayout.removeAll();
                createBtns( c_list.get(i) );
            }
        });
    }
}