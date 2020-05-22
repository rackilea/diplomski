public class Test {
  public int f(boolean a, boolean b, boolean c, boolean d) {
    if (a && b && c && d) {
      return 1;
    } else {
      return 2;
    }
  }

  public int g(boolean a, boolean b, boolean c, boolean d) {
    if (a)
      if (b)
        if (c)
          if (d)
            return 1;
    return 2;
  }
}