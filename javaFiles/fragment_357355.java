public class DownloadTask extends Task<Void> {
  public Void call() {
    while ((bytesRead = inputStream.read(bytesArray)) != -1){
      outputStream2.write(bytesArray, 0, bytesRead);
      bytes += bytesRead;
      updateProgress(bytes, ftpFileSize);
    }
  }
}