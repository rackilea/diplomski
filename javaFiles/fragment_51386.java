private Context context;

 public MenuClass(Context context){
     this.context = context;
 }

 private void someMethod(){
     // Do your stuff
     startNextActivity();
 }

 private void startNextActivity(){
      context.startActivity(context, OtherClass.class);
 }