// inside your getSalesUserData() method
ExecutorService emailExecutor = Executors.newSingleThreadExecutor();
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
        emailExecutor.shutdown(); // it is very important to shutdown your non-singleton ExecutorService.