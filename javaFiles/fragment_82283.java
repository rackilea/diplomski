RelativeLayout relMainActivity ;

@Override
protected void onCreate(Bundle savedInstanceState) {

    // ...
    Designer design = new Designer();
    relMainActivity = design.createDesign(relMainActivity, this);
    // relMainActivity = null in debug

    setContentView(relMainActivity);

}