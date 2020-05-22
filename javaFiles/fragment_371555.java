if (foo && bar) {
  System.out.println("both foo and bar are true");
} else if (foo && !bar) {
    System.out.println("foo is true, but bar is false");
} else if (!foo && bar) {
    System.out.println("foo is false, but bar is true");
} else {
    System.out.println("foo and bar are both false");
}