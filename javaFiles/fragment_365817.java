protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //for listView 1
    linearLayout  = (LinearLayout) findViewById(R.id.linear);
    news1 = (Button) findViewById(R.id.news1);
    news1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            layoutInflater = (LayoutInflater) getApplication().getSystemService(LAYOUT_INFLATER_SERVICE);
            ViewGroup container  = (ViewGroup) layoutInflater.inflate(R.layout.news,null);

            popupWindow = new PopupWindow(container,800,1300,true);
            lst = container.findViewById(R.id.listView1);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,local);
            lst.setAdapter(adapter);
            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(MainActivity.this,local[i],Toast.LENGTH_SHORT).show();
                }
            });

            popupWindow.showAsDropDown(news1);
            container.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    popupWindow.dismiss();
                    return false;
                }
            });
        }
    });

}