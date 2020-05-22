String text = "a|3|bad1|0|b|6|bad1|1|c|5|bad2|1|d|2|bad1|0|e|1|bad2|0";
String[] tokens = text.split("\\|");
Map<String, String> pairs = new HashMap<>();
for(int i = 0; i < tokens.length; i+=2) {
    if(!tokens[i].startsWith("bad")) {
        pairs.put(tokens[i], tokens[i + 1]);
    }
}