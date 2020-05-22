myActivity.runOnUiThread(new Runnable() {

 public void run() {
    Toast.makeText(context, text, duration).show();
 }

});