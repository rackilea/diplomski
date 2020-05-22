public static void main(String[] args) throws Exception {
    Future[] futures = new Future[10];
    ExecutorService ex = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 10; i++) {
        Callable worker = new Worker(i);

        futures[i] = ex.submit(worker);

    }
    for (int i = 0; i < 10; i++) {
        String resultString = (String) futures[i].get();
        System.out.println(resultString);
    }
    ex.shutdown();
    while (!ex.isTerminated());
}

}

class Worker implements Callable<String> {

private final int num;

public Worker(int num) {
    super();
    this.num = num;
}

@Override
public String call() throws Exception {
    String result = null;
    System.out.println("starting job " + num);
    try {
        Thread.sleep(2000);
        System.out.println("end job " + num);
        result = "result" + num;

    } catch (Exception e) {
        e.printStackTrace();
    }
    return result;
}