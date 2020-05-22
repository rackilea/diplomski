import java.io.*;

public class Record {
  private byte[] kdgex = new byte[2]; // COMP
  private byte[] b1code = new byte[2]; // COMP
  private byte[] b1number = new byte[8]; // DISPLAY
  // other fields

  public void read(DataInput data) throws IOException {
    data.readFully(kdgex);
    data.readFully(b1code);
    data.readFully(b1number);
    // other fields
  }

  public void write(DataOutput out) throws IOException {
    out.write(kdgex);
    out.write(b1code);
    out.write(b1number);
    // other fields
  }
}