while (a < 1000) {
  if ((a + 1) % 3 == 0) {
    x = (x + a);
  } else if ((a + 1) % 5 == 0) {
    x = (x + a);
  } else {
    x = (a + 1);
  }
  if (a == 1000) {
    break; // <-- missing semicolon.
  }
  System.out.println(x); // <-- print.
  a++; // <-- increment a.
}