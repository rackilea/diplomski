TaskTimer t = new TaskTimer(2000);
    t.start();
    t.scheduleTask(new Runnable() {
        @Override
        public void run() {
            System.out.println("1");
        }
    });

    t.tryScheduleTask(new Runnable() {
        @Override
        public void run() {
            System.out.println("2");
        }
    });