new Handler(Looper.getMainLooper()).post(new Runnable() {
    @Override
    public void run() {
       Toast.makeText(MyActivity.this,
                    "message", Toast.LENGTH_LONG).show();
    }
});