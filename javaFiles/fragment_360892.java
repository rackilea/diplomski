$ cat Test.java
import java.util.regex.*;
import java.util.logging.*;
import java.math.*;

class Test {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("test");
        String text = "0\0";
        logger.info("parseBigDecimalFromText("+text+")");
        new BigDecimal(text);
    }
}

$ javac Test.java
$ java Test
Nov 06, 2014 12:55:40 AM Test main
INFO: parseBigDecimalFromText(0)
Exception in thread "main" java.lang.NumberFormatException
        at java.math.BigDecimal.<init>(BigDecimal.java:470)
        at java.math.BigDecimal.<init>(BigDecimal.java:739)
        at Test.main(Test.java:10)
$