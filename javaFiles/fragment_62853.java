Thread t = new Thread() {

    @Override
    public void run() {
        try {
            while (!isInterrupted() && i < 12) {
                Thread.sleep(1000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView)findViewById(R.id.randomTextView)).setText(round1[i]);
                        i++;
                    }
                });
            }
            Proceed();
        } catch (InterruptedException e) {
        }
    }
};

t.start();