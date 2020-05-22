private class LoadingBarThread extends Thread {
   Handler handler = new Handler();
    @Override
    public void run() {
        for (int i=0;i<=100;i++) {
            progressBar.setProgress(i);
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        handler.post(new Runnable() {
           public void run() {
             callback();
           }
        });
    }
}