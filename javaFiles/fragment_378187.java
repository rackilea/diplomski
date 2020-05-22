Map<String, ArrayList<String>> dictionary = new HashMap<String, ArrayList<String>>();
for (String currentString : array) {
    String month = currentString.split("-")[1];
    ArrayList<String> values = dictionary.get(month);
    if (values == null) {
        values = new ArrayList<String>();
    }
    values.add(currentString);
    dictionary.put(month, values);
}