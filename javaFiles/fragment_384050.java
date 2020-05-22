while (true) {
                long current = getCounter();
                if (current >= 100) {
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " : " + current);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                   
            }