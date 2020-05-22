public final class ByteArrayHashFunction extends AbstractStreamingHashFunction {

  @Override
  public Hasher newHasher() {
    return new ByteArrayHasher();
  }

  @Override
  public int bits() {
    return 32;
  }

  private static final class ByteArrayHasher extends AbstractByteHasher {

    private int hash = 1;

    @Override
    protected void update(byte b) {
      hash = 31 * hash + b;
    }

    @Override
    public HashCode hash() {
      return HashCode.fromInt(hash);
    }
  }
}