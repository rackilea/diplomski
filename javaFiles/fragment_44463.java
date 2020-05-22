public class MyStringLongMapper {

    public Long stringToLong(String string) {
        return string != null && !string.isEmpty() ? Long.parseLong( string ) : null;
    }

}