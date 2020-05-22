%javamethodmodifiers get_value "private";

%pragma(java) modulecode=%{
  public static int get_value(Instance instance) {
    int outarr[] = new int[1];
    final int err = test.get_value(instance, outarr);
    if (0!=err) {
      // throw, blah blah
    }
    return outarr[0];
  }
%}