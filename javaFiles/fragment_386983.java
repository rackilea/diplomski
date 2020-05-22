public final class ConverterHelper {
   private ConverterHelper() {}

   public static <A,B> List<B> convertList(IConvert<A,B> converter, List<A> list)
   {
      List<B> bs=new ArrayList<B>();
      for (A a : list) {
         bs.add(converter.convert(a));
      }
      return bs;
   }
}