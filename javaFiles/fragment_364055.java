JobInstance job1 = new JobInstance("A");
    JobInstance job2 = new JobInstance("B");
    ArrayList<Job> jobLists = new ArrayList<>();
    jobLists.add(job1);
    jobLists.add(job2);
    Process process = new Process(jobLists);
    System.out.println(Thread.currentThread().getName());
    Thread thread = new Thread(process);
    thread.start();

    try {
        Thread.sleep(15000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    thread.interrupt();