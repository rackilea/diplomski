public void println(char x[]) {
    synchronized (this) {
      print(x);
      newLine();
   }
}