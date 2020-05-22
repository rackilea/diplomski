runOnUiThread(new Runnable() {            
    @Override
    public void run() {
        //this will run on UI thread, so its safe to modify UI views.
         _txtArea.setText("Changed");
    }
});