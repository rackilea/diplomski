Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //your exception handling code should come here
            }
        };

t1.setUncaughtExceptionHandler(exceptionHandler);