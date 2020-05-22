String value = "[[0, 0] -> 0, [0, 1] -> 1, [0, 2] -> 2, [1, 0] -> 3, [0, 4] -> 1, [0, 1] -> 2, [0, 6] -> 3, else -> 2";
value = value.replaceAll("\\[", "");
value = value.replaceAll("\\]", "");
value = value.replaceAll(" ", "");               // remove spaces, too,
                                                 // no need to trim later
int start = 0;
while (start < value.length()) {
    int arrow = value.indexOf("->", start);      // next -> after start
    int comma = value.indexOf(",", arrow);       // next comma after ->
    comma = comma > -1 ? comma : value.length(); // final segment?

    String segment = value.substring(start, comma);
    String key = segment.split("->")[0];         // before ->
    String val = segment.split("->")[1];         // after ->

    if (key.contains("else")) {
        System.out.println("Default: " + val);
    } else {
        String[] keys = key.split(",");
        System.out.println(Arrays.toString(keys) + ": " + val);
    }
    start = comma + 1;                           // continue after segment
}