public void onClickStart (View view) {
    Thread timer = new Thread(){
        public void run() {
            ...
            runOnUiThread(new Runnable() {
                public void run() {
                    setLabelText();
                }
        }
    };
    timer.start();
}