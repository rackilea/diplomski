private void startingUp() {
    Thread timer = new Thread() { //new thread         
        public void run() {
            Boolean b = true;
            try {
                do {
                    counter++;
                    title();
                    sleep(1000);

                    runOnUiThread(new Runnable() {  
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub

                        title.clearComposingText();
                    }
                });


                }
                while (b == true);
            } catch (IntruptedException e) {
                e.printStackTrace();
            }
            finally {
            }
        };
    };
    timer.start();
}