Object lock=new Object();
timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
            System.out.println("1");
                try {

                System.out.println("2");
                System.out.println("3");

                runOnUiThread(new  Runnable() {

                    public void run() {
                        System.out.println("4");
                        System.out.println("5");
                        System.out.println("6");
                        System.out.println("7");
                        synchronized(lock){lock.notify();}
                    }
                });
                try{
                   synchronized(lock){lock.wait();}
                }catch(InterruptedException x){}
                System.out.println("8");
            } catch (Exception e) {

                e.printStackTrace();
            }

        }

    }, delay, period);
    System.out.println("9");