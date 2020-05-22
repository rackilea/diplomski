//get the parentView...
parentView.post(new Runnable() {
    public void run () {
        // it works without the runOnUiThread, but all UI updates must 
        // be done on the UI thread
        activity.runOnUiThread(new Runnable() {
            public void run() {
                parentView.removeView(view);
            }
        });
    }
}