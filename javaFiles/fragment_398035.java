public static class TestInputSplit extends InputSplit implements Writable {

    @Override
    public long getLength() throws IOException, InterruptedException {
      return 0L;
    }

    @Override
    public String[] getLocations() throws IOException, InterruptedException {
      return new String[0];
    }

    @Override
    public void readFields(DataInput arg0) throws IOException {}

    @Override
    public void write(DataOutput arg0) throws IOException {}
  }