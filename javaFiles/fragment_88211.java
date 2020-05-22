public static void print() throws IOException {
  char w[] = {'h','e','l','l','o'};

  for (int i = 0; i < w.length; i++) {
    char c = (char) System.in.read();
    if(c == 13)
        continue;

    System.out.println(w[i]);
  }
}