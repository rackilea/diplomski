Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,"hiii dhruv", Toast.LENGTH_LONG).show();
            }
        });