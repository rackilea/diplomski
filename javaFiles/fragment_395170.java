public void showDialog(Context context){
   Dialog dialog = new Dialog(context);
   dialog.setCancelable(true);
   dialog.setContentView(R.layout.layout);
   dialog.show();
}