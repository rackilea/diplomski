private void initialize() {
    ...
    new Thread() {
        int counter = 10;
        public void run() {
            while(counter >= 0) {
                lblNewLabel.setText("Test" + (counter--));
                try{
                    Thread.sleep(1000);
                } catch(Exception e) {}
            }
        }
    }.start();
}