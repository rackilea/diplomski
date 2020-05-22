import java.io.*;
public class CodePointReader implements Closeable {
  private final Reader charSource;
  private int codeUnit;

  public CodePointReader(Reader charSource) throws IOException {
    this.charSource = charSource;
    codeUnit = charSource.read();
  }

  public boolean hasNext() { return codeUnit != -1; }

  public int nextCodePoint() throws IOException {
    try {
      char high = (char) codeUnit;
      if (Character.isHighSurrogate(high)) {
        int next = charSource.read();
        if (next == -1) { throw new IOException("malformed character"); }
        char low = (char) next;
        if(!Character.isLowSurrogate(low)) {
          throw new IOException("malformed sequence");
        }
        return Character.toCodePoint(high, low);
      } else {
        return codeUnit;
      }
    } finally {
      codeUnit = charSource.read();
    }
  }

  public void close() throws IOException { charSource.close(); }
}