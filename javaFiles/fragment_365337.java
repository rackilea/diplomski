enum DataType {
  connectPlayer {
    @Override
    public String build(String... args) {
      if (args.length != 2) throw new IllegalArgumentException("wrong number of arguments");
      String UUID = args[0];
      String server = args[1];
      return "connectPlayer:" + UUID + ":" + server;
    }
  },
  returnServerState {
    @Override
    public String build(String... args) {
      // do something else here...
      return "returnServierStateArgs " + Arrays.toString(args);
    }
  };

  public abstract String build(String... args);
}