public class TestMultiThread {
@Test
public void testThread(){
    final ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.execute(new ReportSenderRunnable());
    System.out.println("started Report Sender Job");
}
}