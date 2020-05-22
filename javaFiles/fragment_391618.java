public class SharedBuffer {

  private volatile byte[] _buf;

  public void write(byte[] buf) {
    _buf = buf;
  }

  public byte[] read() {
    // maybe copy here if you are worried about passing out the internal reference
    return _buf;
  }
}