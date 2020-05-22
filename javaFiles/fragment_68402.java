import java.util.*;
abstract class Parser<T> {

    private Map<String,T> cache = new HashMap<String,T>();

    public final T parseString(String str) {
        T result = cache.get(str);
        if(result == null) {
            result = parseString0(str);
            cache.put(str,result);
        }
        return result;
    }

    protected abstract T parseString0(String str);

}

public class IntParser extends Parser<Integer> {

    protected Integer parseString0(String str) {
        return Integer.parseInt(str.trim());
    }

}

public class LongParser extends Parser<Long> {

    protected Long parseString0(String str) {
        return Long.parseLong(str.trim());
    }

}

class ParserTest {
    public static void main(String[] args) {
        Parser<Integer> intParse = new IntParser();
        Parser<Long> longParse = new LongParser();

        Long long1 = longParse.parseString("10000");
        Long long2 = longParse.parseString("20000");
        Long long3 = longParse.parseString("30000");
        Long equalLong = longParse.parseString("20000"); // repeat long2
        Long fakeLong = new LongParser().parseString("20000"); // repeated with fake
        System.out.println("Expecting true: " + (long2 == equalLong));
        System.out.println("Expecting false: " + (fakeLong == equalLong));
    }
}

C:\Documents and Settings\glowcoder\My Documents>javac Parser.java

C:\Documents and Settings\glowcoder\My Documents>javac IntParser.java

C:\Documents and Settings\glowcoder\My Documents>javac LongParser.java

C:\Documents and Settings\glowcoder\My Documents>javac ParserTest.java

C:\Documents and Settings\glowcoder\My Documents>java ParserTest
Expecting true: true
Expecting false: false