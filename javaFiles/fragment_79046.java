public final class Test {
   @NotNull
   private static final String[] FRAGMENTS;
   ...

   static {
      String[] elements$iv = new String[]{"phong-lighting", "phong-only", "blinn-lighting", "blinn-only"};
      FRAGMENTS = (String[])((Object[])elements$iv);
   }
}