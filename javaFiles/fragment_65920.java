private Context context;

public MyCustomComponent(Context context){
  this.context = context;
}

public void addImageView(final int belowId,final int id){
    ((Activity)this.context).runOnUiThread(new Runnable() {
       ....
    }
}