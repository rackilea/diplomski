@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activity_main);
        ConstraintSet set = new ConstraintSet();
        set.clone(layout);

        //Button 1:
        Button button = new Button(this);
        button.setText("Hello");
        button.setId(100);           // <-- Important
        layout.addView(button);
        set.connect(button.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        set.connect(button.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
        set.connect(button.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
        set.constrainHeight(button.getId(), 200);
        set.applyTo(layout);


        //Button 2:
        Button newButton = new Button(this);
        newButton.setText("Yeeey");
        layout.addView(newButton);
        set.connect(newButton.getId(), ConstraintSet.BOTTOM, button.getId(), ConstraintSet.TOP, 0);
        set.connect(newButton.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
        set.connect(newButton.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
        set.constrainHeight(newButton.getId(), 200);
        set.applyTo(layout);


    }