@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main); // the XML layout you created.

    View = (ClasseCanvas) findViewById(R.id.View); // the ClasseCanvas view in your XML file.
    View.setOnTouchListener(this);

    Font = Typeface.createFromAsset(getAssets(), "TF2.ttf");

    TextP.setColor(Color.RED);
    TextP.setTextSize(50);
    TextP.setTypeface(Font);

    xApple = yApple = xBasket = yBasket = 0;
    xApple = rnd.nextInt(600);

    Apple = BitmapFactory.decodeResource(getResources(), R.drawable.apple);
    BackG = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
    Basket = BitmapFactory.decodeResource(getResources(),R.drawable.basket);

}