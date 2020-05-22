Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("RT", "Thread t Begins");
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
        t.start();