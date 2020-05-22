class SycnronousService impliments ExecutorService {

    //methods empty implementations

    public void submit(Runnable runnable) {
        runnable.run(); //run immediately
    }

    //methods empty implementations
}

public class ServiceTest {

    public void shouldPassAllItemsToDownloader() {
        Downloader mockDownloader = AnyMockFramework.mockIt();
        Service service = new Service(mockDownloader, new SycnronousService());
        List<String> tasks = Arrays.asList("A", "B");
        service.doWork(tasks);
        verify(mockDownloader).download("A"); //verify in your way with EasyMock
        verify(mockDownloader).download("B"); //verify in your way with EasyMock
        // no more Timer.sleep() , test runs immeadetely  
    }

}