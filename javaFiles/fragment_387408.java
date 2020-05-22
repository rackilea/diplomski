///---////
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

     this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


         Button exit = (Button) findViewById(R.id.but);
         exit.setOnClickListener(new View.OnClickListener() {

             @Override
                public void onClick(View arg0) {
                   final Dialog openDialog = new Dialog(MainActivity.this);
                   openDialog.setContentView(R.layout.main);
                   openDialog.setTitle("Confirm Exit");
                   TextView dialogTextContent = (TextView)openDialog.findViewById(R.id.exitimage);

                   Button dialogExitButton = (Button)openDialog.findViewById(R.id.buttonexityes);
                   dialogExitButton.setOnClickListener(new OnClickListener(){                                      
                      @Override
                      public void onClick(View v) {
                         finish();
                         } 
                   });
                   Button dialogCloseButton = (Button)openDialog.findViewById(R.id.buttonexitno);
                   dialogCloseButton.setOnClickListener(new OnClickListener(){
                      @Override
                      public void onClick(View v) {
                          openDialog.dismiss();
                      }                                                                             
                 });                   
                 openDialog.show();
              }
           });

}