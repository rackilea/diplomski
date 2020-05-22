try {
  PrintWriter writer = new PrintWriter("angle.txt", "UTF-8");
  for (i = 1; i < i_max; i = i + 1) {
    writer.printf("%1$16.6f%2$16.6f%n", time[i], theta[i]);
  }
  writer.close();
} catch (IOException ioe) {
  System.out.println(ioe);
}