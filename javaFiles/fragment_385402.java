public void onClickStart (View view){
    Thread timer = new Thread(){
        runOnUiThread(new Runnable() {
            public void run() {
                ...
            }
        });
    };
}