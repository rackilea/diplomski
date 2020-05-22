protected Void doInBackground(Void... params) {
            Handler handler = new Handler();                 //Declared on worker thread.
            Looper.prepare();
            handler.post(new Runnable(){
                @Override
                public void run() {
                    loc = getLocation();//this blocks the activity
                }
            });
            return null;
        }