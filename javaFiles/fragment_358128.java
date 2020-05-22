Runnable ppt = new Runnable() {
                public void run() {
                    try {
                    processTask();
                    } catch(Exception e) {
                        System.out.println(e.getMessage());

                    }
                }
            };
         executor.scheduleWithFixedDelay(ppt, 0, 1000/20, TimeUnit.MILLISECONDS);