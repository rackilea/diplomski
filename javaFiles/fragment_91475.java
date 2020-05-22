abstract class FileProcessor<T> {
  public void processFile() {};
  protected abstract T processLine(aLine); // implemented by the subclass
  public abstract T getData();
}

public ConfigFileProcessor extends FileProcessor<Configuration>{ ... }
public RecordFileProcessor extends FileProcessor<Record>{ .. }