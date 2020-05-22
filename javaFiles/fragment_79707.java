new Thread() {
    public void run() {
        final String data = getServerData(KEY_121);
        if (data != null)
            runOnUiThread(new Runnable()
            {
                public void run()
                {
                    txt.setText(data);
                }
            });
    }
}.start();