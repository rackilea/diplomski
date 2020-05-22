public static Integer max(Integer... ints) {
    long ret = Long.MIN_VALUE;
    for (Integer i: ints) 
      if (null != i && i > ret) 
        ret = i;
    return ret >= Integer.MIN_VALUE? (int) ret : null;
}