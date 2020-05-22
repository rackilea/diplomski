import java.io.BufferedReader;
import java.io.IOException;   
public class LineReader {   
  private int i = -2;
  private BufferedReader br;
  public OriginalLineReader(BufferedReader br) { this.br = br; }
  public String readLine() throws IOException {
    if (i == -2) i = br.read();
    if (i < 0) return null;
    StringBuilder sb = new StringBuilder();
    sb.append((char)i);
    if (i != '\r' && i != '\n') {
      while (0 <= (i = br.read()) && i != '\r' && i != '\n') {
        sb.append((char)i);
      }
      if (i < 0) return sb.toString();
      sb.append((char)i);
    }
    if (i == '\r') {
      i = br.read();
      if (i != '\n') return sb.toString(); 
      sb.append((char)'\n');
    }
    i = -2;
    return sb.toString();
  }
}