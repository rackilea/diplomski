class CountingOutputStream extends OutputStream {
  private int _total;

  @Override public void write(int b) {
    ++_total;
  }

  @Override public void write(byte[] b) {
    _total += b.length;
  }

  @Override public void write(byte[] b, int offset, int len) {
    _total += len;
  }

  public int getTotalSize(){
     _total;
  }
}

CountingOutputStream cos = new CountingOutputStream();
Writer writer = new OutputStreamWriter(cos, "my_encoding");
//writer.write(myString);

// UPDATE: OutputStreamWriter does a simple copy of the _entire_ input string, to avoid that use:
for(int i = 0; i < myString.length(); i+=8096) {
  int end = Math.min(myString.length(), i+8096);
  writer.write(myString, i, end - i);
}

writer.flush();

System.out.println("Total bytes: " + cos.getTotalSize());