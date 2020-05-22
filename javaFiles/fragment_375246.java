public void mAsyncTask() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                while (--Here put a boolean--) {
                    mediaPlayer.start();
                    try {
                        Thread.sleep(--put here a pause in millisec--);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }.execute();
    }