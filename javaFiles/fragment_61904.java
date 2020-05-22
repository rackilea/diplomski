import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import static javax.json.stream.JsonParser.Event.KEY_NAME;
import static javax.json.stream.JsonParser.Event.VALUE_FALSE;
import static javax.json.stream.JsonParser.Event.VALUE_NUMBER;
import static javax.json.stream.JsonParser.Event.VALUE_STRING;
import static javax.json.stream.JsonParser.Event.VALUE_TRUE;

/**
 *
 * @author blj0011
 */
public class JSONParserTest {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String jsonString = "{\n" +
                            "  \"json\": {\n" +
                            "    \"abc\": 0,\n" +
                            "    \"def\": \"100\",\n" +
                            "    \"ghi\": 1,\n" +
                            "    \"jkl\": \"0000000000\",\n" +
                            "    \"mno\": \"3\",\n" +
                            "    \"pqr\": \"COLS, COMPLETE\",\n" +
                            "    \"stu\": 2,\n" +
                            "    \"vwx\": \"0000010000\",\n" +
                            "    \"yz\": \"00\",\n" +
                            "    \"a123\": 31,\n" +
                            "    \"b123\": 1,\n" +
                            "    \"c123\": \"1270\",\n" +
                            "    \"d123\": \"2\",\n" +
                            "    \"e123\": \"00\",\n" +
                            "    \"f123\": 1,\n" +
                            "    \"g123\": \"0000001000\"\n" +
                            "  },\n" +
                            "  \"_indexes\": {\n" +
                            "    \"c123\": [\n" +
                            "      \"1270\"\n" +
                            "    ],\n" +
                            "    \"h123\": [\n" +
                            "      \"1270\"\n" +
                            "    ]\n" +
                            "  },\n" +
                            "  \"_d\": false,\n" +
                            "  \"_dd\": \"2017-09-12T12:03:53.716Z\",\n" +
                            "  \"_op\": \"add\",\n" +
                            "  \"_id\": 2\n" +
                            "},\n" +
                            "{\n" +
                            "  \"json\": {\n" +
                            "    \"abc\": 0,\n" +
                            "    \"def\": \"100\",\n" +
                            "    \"ghi\": 1,\n" +
                            "    \"jkl\": \"0000000000\",\n" +
                            "    \"mno\": \"3\",\n" +
                            "    \"pqr\": \"COLS, COMPLETE\",\n" +
                            "    \"stu\": 2,\n" +
                            "    \"vwx\": \"0000010000\",\n" +
                            "    \"yz\": \"00\",\n" +
                            "    \"a123\": 31,\n" +
                            "    \"b123\": 1,\n" +
                            "    \"c123\": \"1270\",\n" +
                            "    \"d123\": \"2\",\n" +
                            "    \"e123\": \"00\",\n" +
                            "    \"f123\": 1,\n" +
                            "    \"g123\": \"0000001000\"\n" +
                            "  },\n" +
                            "  \"_indexes\": {\n" +
                            "    \"c123\": [\n" +
                            "      \"1270\"\n" +
                            "    ],\n" +
                            "    \"h123\": [\n" +
                            "      \"1270\"\n" +
                            "    ]\n" +
                            "  },\n" +
                            "  \"_d\": false,\n" +
                            "  \"_dd\": \"2017-09-12T12:03:53.716Z\",\n" +
                            "  \"_op\": \"add\",\n" +
                            "  \"_id\": 2\n" +
                            "},\n" +
                            "{\n" +
                            "  \"json\": {\n" +
                            "    \"abc\": 0,\n" +
                            "    \"def\": \"100\",\n" +
                            "    \"ghi\": 1,\n" +
                            "    \"jkl\": \"0000000000\",\n" +
                            "    \"mno\": \"3\",\n" +
                            "    \"pqr\": \"COLS, COMPLETE\",\n" +
                            "    \"stu\": 2,\n" +
                            "    \"vwx\": \"0000010000\",\n" +
                            "    \"yz\": \"00\",\n" +
                            "    \"a123\": 31,\n" +
                            "    \"b123\": 1,\n" +
                            "    \"c123\": \"1270\",\n" +
                            "    \"d123\": \"2\",\n" +
                            "    \"e123\": \"00\",\n" +
                            "    \"f123\": 1,\n" +
                            "    \"g123\": \"0000001000\"\n" +
                            "  },\n" +
                            "  \"_indexes\": {\n" +
                            "    \"c123\": [\n" +
                            "      \"1270\"\n" +
                            "    ],\n" +
                            "    \"h123\": [\n" +
                            "      \"1270\"\n" +
                            "    ]\n" +
                            "  },\n" +
                            "  \"_d\": false,\n" +
                            "  \"_dd\": \"2017-09-12T12:03:53.716Z\",\n" +
                            "  \"_op\": \"add\",\n" +
                            "  \"_id\": 2\n" +
                            "}"; //I am guessing this is how your data looks.


        List<Integer> positions = new ArrayList();
        Pattern p = Pattern.compile("\\},\n\\{");//Find this pattern ***MAKE SURE THIS PATTERN IS CORRECT FOR YOU*** Your patter may be "\\},\\{"
        Matcher m = p.matcher(jsonString);
        while(m.find())
        {
            positions.add(m.start() + 1);//save starting position of the found pattern
        }

        System.out.println("# of positions: " + positions.size());
        List<String> jsonStringObjects = new ArrayList();

        if(positions.size() >= 1)
        {
            jsonStringObjects.add(jsonString.substring(0, positions.get(0)));//get first jsonString
            //System.out.println(jsonString.substring(0, positions.get(0)));   
            jsonStringObjects.add(jsonString.substring(positions.get(positions.size() - 1) + 1));//get last jsonString
            //System.out.println(jsonString.substring(positions.get(positions.size() - 1) + 1));   
        }
        if(positions.size() >= 2  )
        for(int i = 0; i < positions.size() - 1; i++)//get all jsonStrings between first and last
        {              
            jsonStringObjects.add(jsonString.substring(positions.get(i) + 1, positions.get(i + 1)));
            //System.out.println(jsonString.substring(positions.get(i) + 1, positions.get(i + 1)));           
        }                

        System.out.println("# of jsonStringObjects: " + jsonStringObjects.size());
        int counter = 0;
        for(String item : jsonStringObjects)
        {
            System.out.println("JSON Object #: " + ++counter);
            try (JsonParser parser = Json.createParser(new StringReader(item))) {
                while (parser.hasNext()) {
                    final Event event = parser.next();
                    switch (event) {
                        case KEY_NAME:
                            String key = parser.getString();
                            System.out.println("\t" + key);
                            break;
                        case VALUE_STRING:
                            String value = parser.getString();
                            System.out.println("\t" + value);
                            break;
                        case VALUE_NUMBER:
                            BigDecimal number = parser.getBigDecimal();
                            System.out.println("\t" + number);
                            break;
                        case VALUE_TRUE:
                            System.out.println("\t" + true);
                            break;
                        case VALUE_FALSE:
                            System.out.println("\t" + false);
                            break;
                    }
                }
            }
        }
    }

}