public void startScan(){
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            mainWifiObj.startScan();
            startScan();
        }
    }, 5*1000);
}