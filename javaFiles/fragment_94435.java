ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

exec.schedule(new Runnable() {
          public void run() {
              myHashSet.add(foo);
          }
     }, 1, TimeUnit.SECONDS);