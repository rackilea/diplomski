public class FileReader implements Runnable {

String fileName;

public FileReader(String fileName) {
   this.fileName = fileName;
}

public void run() {

 processFile(fileName);

}

private void processFile(String fileName) {
  // Your logic of processing the file.
}

}