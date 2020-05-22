@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_information);

    //readTask = new ReadTask();
    Typeface type = Typeface.createFromAsset(getAssets(),"fonts/41370_WINDSORCONDENSED.TTF");

    label2 = (TextView) findViewById(R.id.label_2_id_here);
    label2.setText("Text here\n");
    label2.setTextColor(Color.rgb(0,0,0));
    label2.setBackgroundColor(Color.rgb(255,194,75));
    label2.setTypeface(type);
}