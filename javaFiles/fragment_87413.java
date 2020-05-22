protected Void startNewLayout() {   

    LinearLayout myLayout = new LinearLayout(context);
    myLayout.setOrientation(LinearLayout.VERTICAL);

    // creating LayoutParams  
    LayoutParams layoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT); 
    // set LinearLayout as a root element of the screen 
    setContentView(myLayout, layoutParam);    

    LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    Toolbar toolbar = new Toolbar(context);
    toolbar.setTitle("Page#1");
    toolbar.setLayoutParams(lpView);
    myLayout.addView(toolbar);

    TextView text = new TextView(context);
    text.setText("Hello World!");
    text.setLayoutParams(lpView);
    myLayout.addView(text);


}