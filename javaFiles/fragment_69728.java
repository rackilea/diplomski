public static int length (LinkedList l)
  {
    if (l == null)
      return 0;
    else
      return 1 + length(l.next);
  }