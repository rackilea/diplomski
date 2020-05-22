public class ProcessJob1 extends Job {

private static Map<String, ExecutorService> isRunning = new HashMap<String, ExecutorService>();

private static ExecutorService executor = Executors.newFixedThreadPool(MAX);

private static CountDownLatch countDownLatch = new CountDownLatch(0);
@Override
public void execute(Map<String, Object> jobData) {


    File[] inputFiles = getValidFiles();
    countDownLatch.await();

    if (inputFiles.length > 0) {
        countDownLatch = new CountDownLatch(inputFiles.length);
        for (File inputFile : inputFiles) {
              case 1:
                  executor.execute(new ProcessFileTask1(inputFile,countDownLatch));
                  break;
              case 2:
                  executor.execute(new ProcessFileTask2(inputFile,countDownLatch));
                  break;
              default:
                  break;
        }
    }
}