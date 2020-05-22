Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
       // show alert to user
       e.printStackTrace();
       // do whatever you want with the Exception e

    });