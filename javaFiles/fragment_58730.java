Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread t, Throwable e) {
            if (e instanceof ExceptionInInitializerError) {
                // do something with you're exception
                // and than close application
                System.exit(-1); // passing 
            }
        }
    });