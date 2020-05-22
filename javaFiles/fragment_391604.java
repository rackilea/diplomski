if (snackbar != null){
    callback.run = new Runnable() {
         void run() {
             finish();
         }
    };
    snackbar.dismiss();
} else {
    finish();
}