Handler hdl = new Handler(); // Will ron on UI-thread

dialog = ProgressDialog.show(Login.this, "", 
        "Logging you in. Please wait...", true);
new Thread() {
     public void run() {
             try{
                  //serious work here!
                }
                hdl.post(new Runnable() {
                    public void run() {
                        dialog.dismiss();
                        setContentView(R.layout.blaa);
                    }
                });
             } catch (Exception e) {
                 e.printStackTrace();
             }
     }
}.start();