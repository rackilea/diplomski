public class UploadFileWorker extends Thread {
String path;
PipedInputStream pis;

public String contentType = "";

public UploadFileWorker(String path, PipedInputStream pis) {
    super();
    this.path = path;
    this.pis = pis;
}

public void run() {
    try {
        myApi.store(pis, path, contentType);
        pis.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        try {pis.close();} catch (Exception ex2) {}
    }
}