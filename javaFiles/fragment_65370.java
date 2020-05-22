public interface Converter<T> {
   public T convert( String arg );
}

public class IntegerConverter implements Converter<Integer> {
   public Integer convert( String arg ) {
       return Integer.parseInt( arg );
   }
}