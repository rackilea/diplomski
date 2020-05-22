Activity activity = (Activity) context;
 try{
     messageReadListener = (OnMessageReadListener) activity;
 }catch (ClassCastException e){
     throw new ClassCastException();
 }