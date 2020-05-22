if (foo) {
  if (bar) {
    System.out.println("both foo and bar are true");
  } else {
    System.out.println("foo is true, but bar is false");
  }
} else {
  if (bar) {
    System.out.println("foo is false, but bar is true");
  } else {
    System.out.println("both foo and bar are false");
  }
}