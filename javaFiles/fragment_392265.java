String all = "&username=john&password=12345&email=john@go.com";
//Split across all instances of the 'and' symbol
String[] keyValueConcat = all.split("&");
Map<String, String> kvPairs = new HashMap<String, String>();
for (String concat : keyValueConcat) {
    if (concat.contains("=") {
        //For any string in the split that contains an equals sign
        //Split over the equals sign and add to the map
        String[] keyValueSplit = concat.split("=", 2);
        kvPairs.put(keyValueSplit[0], keyValueSplit[1];
    }
}