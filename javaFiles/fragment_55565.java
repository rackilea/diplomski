@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Number myNumber = new Number();
    myNumber.input = 22;

    if (myNumber.isTriangular()){
        //do something
    }
    else if (myNumber.isSquare()){
        //do something else        
    }
}