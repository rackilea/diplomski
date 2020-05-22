import java.util.*;
    import java.util.regex.*;
    //...

    String pattern = "(\\w+)\\s*=\\s*\"([^\"]*+)\"";

    String text = "name1 = \"val 1\"    name2=\"val2\"    name3=\"val3\"";
    System.out.println(text);
    // name1 = "val 1"    name2="val2"    name3="val3"

    Matcher m = Pattern.compile(pattern).matcher(text);
    Map<String,String> map = new HashMap<String,String>();
    while (m.find()) {
        map.put(m.group(1), m.group(2));
    }
    System.out.println(map);
    // {name3=val3, name1=val 1, name2=val2}