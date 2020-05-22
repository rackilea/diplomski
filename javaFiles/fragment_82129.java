public class DownloadUtil {

public static void downloadHtml(Executor e, MainViewController controller, String dns, int port, String offlineUUID, String filePath, Map<String, String> cookies) throws IOException {

    ...

    e.execute(new DownloaderTask(controller, urlHtml, filePath, cookies));
}