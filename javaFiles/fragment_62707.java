Map<String, String> styles = new HashMap<>();
styles.put("text-align", "left");
styles.put("background-color", "blue");

String styleString = styles.entrySet().stream()
    .map(e -> e.getKey() + ": " + e.getValue())
    .collect(Collectors.joining(";"));

System.out.println(styleString);