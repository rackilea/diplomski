package com.jbirdvegas.q41267676;

import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

public class YamlExample {
    public static void main(String[] args) throws Exception {

        String yamlInput =
                "rates:\n" +
                        "- 391:\n" +
                        "    mul: 10000\n" +
                        "    store: 5000\n" +
                        "- 392:\n" +
                        "    mul: 9000\n" +
                        "    store: 5000";

        YamlReader reader = new YamlReader(new StringReader(yamlInput));
        Map map = (Map) reader.read();
        // rates is a list
        List<Map> rates = (List<Map>) map.get("rates");
        // each item in the list is a map
        for (Map itemMap : rates) {
            // each map contains a single map the key is [ 391|392 ]
            itemMap.forEach((key, value) -> {
                System.out.println("Key: " + key);
                // the value in in this map is itself a map
                Map embededMap = (Map) value;
                // this map contains the values you want
                System.out.println(embededMap.get("mul"));
                System.out.println(embededMap.get("store"));
            });
        }
    }
}