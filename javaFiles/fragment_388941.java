Thread thread = new Thread(new Runnable() { 
        public void run() { 
        // *** some operations*** 
        } 
        }); 
    thread.start();
    thread.join();