public static void reversePrint (LinkedList l)
  {
    if (l != null) {
      reversePrint(l.next);
      System.out.println(l.value);
    }
  }