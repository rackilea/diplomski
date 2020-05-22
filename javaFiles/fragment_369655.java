void Do_Test() {
    String Info = "", Result;
    Out("Do_Test");
    try {
        Display_Timer.start();
        Timer.Start();
        Output_Time("[ 1 ]");
        Progress_bar.Set_Progress(1);   // OK to call this on the event thread

        int Task_Count = 222;
        executor = new ThreadPoolExecutor(Executor_Count, Executor_Count * 2, 1,
                TimeUnit.SECONDS, new LinkedBlockingQueue());
        ArrayList<Future<String>> futures = new ArrayList<>(Task_Count);
        Test_Runner A_Runner;

        try {
            for (int i = 0; i < Task_Count; i++) {
                A_Runner = new Test_Runner();
                futures.add(executor.submit(A_Runner));
            }
            executor.shutdown();