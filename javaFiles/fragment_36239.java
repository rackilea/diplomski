Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

        @Override
        public void run() {
            //TODO stop web server and close db connection if needed

        }
    }));