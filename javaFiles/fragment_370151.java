InputStreamReader isr = new InputStreamReader(System.in, StandardDefaultCharsets.UTF_8);
for (;;) {
  System.out.println("Enter an Alphabet");
  int n = isr.read();
  if (n == -1) break; // end of stdin.
  char ch = (char) n;
  // the if here
}