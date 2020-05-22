public enum Signal{
  ...

  public static Signal byValue(String value) {
    Singal[] signales = Signal.getEnumConstants();
    for (Signal s:signals) {
       if (s.getValue().equals(value) {
         return s;
       }
    }
  }
}