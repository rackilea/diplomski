package jsonpath;

import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Option;
import static com.jayway.jsonpath.JsonPath.*;

public class GetPaths {

    public static void main(String [] args) {
        String json = "{\"top_field\": { \"mid_field\": [ { \"my_field\": true, }, { \"my_field\": true, } ], \"another_mid_field\": [ { \"my_field\": false } ] }}";

        Configuration conf = Configuration.builder().options(Option.AS_PATH_LIST).build();
        List<String> pathList = using(conf).parse(json).read("$..my_field");
        for(String path : pathList) {
            System.out.println(path);
        }
    }
}