@Override
        public void uncaughtException(Thread t, Throwable e) {
            if (e instanceof RuntimeException) {
                 e.printStackTrace();
                 System.exit(1);
            } 
        }