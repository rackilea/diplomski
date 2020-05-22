public class runner {

private static Long START_NUM = 1L;
private static Long END_NUM =   10000000L;

public static void main(String[] args) {
    Long preciseStartingTime = new Long(System.currentTimeMillis());

    ForkJoinPool pool = new ForkJoinPool();
    WorkManager worker = new WorkManager(START_NUM, END_NUM);
    pool.invoke(worker);

    System.out.println("precise time: " + (System.currentTimeMillis() - preciseStartingTime));
}