new Handler().post(new Runnable() {
        public void run() {
            ThreadA threadA = new ThreadA();
            try{
                try {

                    try{
                        result=threadA.execute().get(10, TimeUnit.SECONDS);
                    }
                    catch (TimeoutException e){
                        Log.e(TAG,Log.getStackTraceString(e));
                    }
                }
                catch (InterruptedException e){
                    Log.e(TAG,Log.getStackTraceString(e));
                }
            }
            catch (ExecutionException e) {
                Log.e(TAG,Log.getStackTraceString(e));
            }

        }
    });