private static final int NUM_INTS = 1000000;

interface IntWriter {
  void write(int[] ints);
}

public static void main(String[] args) {
  int[] ints = new int[NUM_INTS];
  Random r = new Random();
  for (int i=0; i<NUM_INTS; i++) {
    ints[i] = r.nextInt();
  }
  time("DataOutputStream", new IntWriter() {
    public void write(int[] ints) {
      storeDO(ints);
    }
  }, ints);
  time("ObjectOutputStream", new IntWriter() {
    public void write(int[] ints) {
      storeOO(ints);
    }
  }, ints);
  time("FileChannel", new IntWriter() {
    public void write(int[] ints) {
      storeFC(ints);
    }
  }, ints);
}

private static void time(String name, IntWriter writer, int[] ints) {
  long start = System.nanoTime();
  writer.write(ints);
  long end = System.nanoTime();
  double ms = (end - start) / 1000000d;
  System.out.printf("%s wrote %,d ints in %,.3f ms%n", name, ints.length, ms);
}

private static void storeOO(int[] ints) {
  ObjectOutputStream out = null;
  try {
    out = new ObjectOutputStream(new FileOutputStream("object.out"));
    out.writeObject(ints);
  } catch (IOException e) {
    throw new RuntimeException(e);
  } finally {
    safeClose(out);
  }
}

private static void storeDO(int[] ints) {
  DataOutputStream out = null;
  try {
    out = new DataOutputStream(new FileOutputStream("data.out"));
    for (int anInt : ints) {
      out.write(anInt);
    }
  } catch (IOException e) {
    throw new RuntimeException(e);
  } finally {
    safeClose(out);
  }
}

private static void storeFC(int[] ints) {
  FileOutputStream out = null;
  try {
    out = new FileOutputStream("fc.out");
    FileChannel file = out.getChannel();
    ByteBuffer buf = file.map(FileChannel.MapMode.READ_WRITE, 0, 4 * ints.length);
    for (int i : ints) {
      buf.putInt(i);
    }
    file.close();
  } catch (IOException e) {
    throw new RuntimeException(e);
  } finally {
    safeClose(out);
  }
}

private static void safeClose(OutputStream out) {
  try {
    if (out != null) {
      out.close();
    }
  } catch (IOException e) {
    // do nothing
  }
}