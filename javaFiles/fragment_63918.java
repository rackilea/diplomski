Handler handler = new Handler(Looper.getMainLooper());
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            new RegistroTokenTask(getApplicationContext(), refreshedToken, "", SAVE_ABERTURA).execute();
        }
    }, 2000);