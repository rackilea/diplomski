@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        GridView bottomMapGrid = (GridView)findViewById(R.id.bottomMapGrid);
        bottomMapGrid.setAdapter(new ImageAdapter(this));
        System.out.println("DisplayActivity onCreate done");        
    }