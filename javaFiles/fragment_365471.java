// this should be a singleton
        ExecutorService emailExecutor = Executors.newCachedThreadPool();

        // from you getSalesUserData() method
        emailExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    SendEmailUtility.sendmail(emaildummy);
                } catch (IOException e) {
                    logger.error("failed", e);
                }
            }
        });