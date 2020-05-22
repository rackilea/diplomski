public interface DataConverter<F,T> {
    public T convert( F from );
}

public class SubstringConverter implements DataConverter<String,String> {

    private final int start;

    public SubstringConverter( int start ) { this.start = start; }

    public String convert( String from ) {
        return from.substring( start );
    }

}