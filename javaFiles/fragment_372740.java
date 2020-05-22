@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tv = (TextView)findViewById(R.id.tv);
    int idList[] = {R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four,
        R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.add,
        R.id.sub, R.id.div, R.id.multi, R.id.equal, R.id.clear, R.id.history};

     btnClick = new ButtonClickListener(); // add this line

     for(int id:idList){
        View v = (View)findViewById(id);
        v.setOnClickListener(btnClick);
     }
}