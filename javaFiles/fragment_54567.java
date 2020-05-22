int position;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity); //if your activities have different layouts depending the given position, you can move this line inside the switch function
    ...
    if(getIntent().getExtras() != null) {
        position = getIntent().getExtras().getInt("position", 0);
    }
    switch(position){
        case 1:
            //do something
            break;
        case 2:
            //do another thing
            break;
        default:
            //default behaviour
            break;
    }
}