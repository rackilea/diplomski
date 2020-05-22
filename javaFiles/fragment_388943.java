import java.io.*;
import java.util.*;

import com.univocity.parsers.csv.*;

public class Test {

    public static void main(String ... args){
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\r\n");
        settings.setParseUnescapedQuotes(true); // THIS IS IMPORTANT FOR YOU
        CsvParser parser = new CsvParser(settings);

        String line1 = "something,\"a quoted value \"with unescaped quotes\" can be parsed\", something\r\n";
        System.out.println("Input line: " + line1);

        String line2 = "\"after the newline \r\n you will find \" more stuff\r\n";
        System.out.println("Input line: " + line2);

        List<String[]> allLines = parser.parseAll(new StringReader(line1 + line2));


        int count = 0;
        for(String[] line : allLines){
            System.out.println("Line " + ++count);
            for(String element : line){
                System.out.println("\t" + element);

            }
            System.out.println();
        }
    }
}