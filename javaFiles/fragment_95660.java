Writer out1 = new FileWriter("outx.txt");
try {
  out1 = new BufferedWriter(out1);
  Writer out2 = new FileWriter("outy.txt");
  try {
    out2 = new BufferedWriter(out2);
    for (int i = 0; i < 320 * 240; i++) {
      out1.write(0 + System.getProperty("line.separator"));
      out2.write(0 + System.getProperty("line.separator"));
    }
  } finally {
    out2.close();
  }
} finally {
  out1.close();
}