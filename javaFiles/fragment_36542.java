Thread t = new Thread(new Runnable() 
        {
            public void run() 
            {
                FileConverter fc = new FileConverter();

            }
         });
        t.start();
        if (t.getState().equals(Thread.State.TERMINATED) ) { ... }