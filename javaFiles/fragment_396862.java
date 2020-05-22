Handler handler = new Handler(Looper.getMainLooper());
   handler.post(new Runnable() {
        @Override
        public void run() {
            Toast.makeText(activity, "No tasks.", Toast.LENGTH_SHORT).show();
        }
    });