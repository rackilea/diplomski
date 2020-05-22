public class RenamingFileAppender extends FileAppender {

...

/** fix concurrency issue in stock implementation **/
public synchronized void setFile(String file) {
  super.setFile(file);
}

public synchronized void renameFile(String newName) {
  // whole method is synchronized to avoid losing log messages
  // implementation can be smarter in having a short term queue
  // for any messages that arrive while file is being renamed
  File currentFile = new File(this.fileName);
  File newFile = new File(newName);
  // do checks to ensure current file exists, can be renamed etc.
  ...
  // create a temp file to use while current log gets renamed
  File tempFile = File.createTempFile("renaming-appender", ".log");
  tempFile.deleteOnExit();
  // tell underlying impl to use temporary file, so current file is flushed and closed
  super.setFile(tempFile.getAbsolutePath(), false, this.bufferedIO, this.bufferSize);
  // rename the recently closed file
  currentFile.renameTo(newFile);
  // now go back to the original log contents under the new name. Note append=true
  super.setFile(newFile.getAbsolutePath(), true, this.bufferedIO, this.bufferSize);
}