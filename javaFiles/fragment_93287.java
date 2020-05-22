ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
pool.execute(calculator);

    //make it a daemon thread
Timer timer = new Timer(true);

timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            System.out.println(pool.toString());
        }
    }, 100, 2000);

calculator.join(); // wait for computation