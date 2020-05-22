Thread thread=new Thread(){
        @Override
        public void run() {
            try {
                sleep(5*1000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(i);
                    }
                });

            }
            catch (Exception ex)
            {}
        }
    };
    thread.start();