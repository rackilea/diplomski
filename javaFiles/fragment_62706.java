Map<String, String> styles = new HashMap<>();
styles.put("text-align", "left");
styles.put("background-color", "blue");

StringBuilder stringBuilder = new StringBuilder();
for(Map.Entry<String, String> entry : styles.entrySet()){
    stringBuilder.append(entry.getKey() + ": " + entry.getValue());
    stringBuilder.append(";");
}

//Remove last ; and print
System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 1));