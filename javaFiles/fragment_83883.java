TimerTask DelayTimerTask = new TimerTask() { //task to increase threadpool size

          public void run() {
            MyExecutor.setCorePoolSize(i * incrementAmount);          //timer task increments threadpool size by threadPoolIncrement
            i++;
        }
      };
    timer.scheduleAtFixedRate(DelayTimerTask,0,intervalLength);