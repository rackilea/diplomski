class MyResource implements AutoCloseable {
  private final String name;
  MyResource(String name) { this.name = name; }

  @Override public void close() throws IOException {
    System.out.println("Closing " + name);
    throw new IOException();
  }
}

public static void main(String[] args) throws IOException {
  MyResource a = new MyResource("a");
  MyResource b = new MyResource("b");
  try {
  } finally {
    a.close();
    b.close();
  }
}