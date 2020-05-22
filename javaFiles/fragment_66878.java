Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        public void run() {
            progressDialog.dismiss();
        }
    }, 1000 * 50);