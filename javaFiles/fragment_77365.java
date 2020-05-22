String[] strings = str.split("\n");
StringBuilder resultBuilder = new StringBuilder();
for (int i = 0; i < strings.length; i++) {
    String s = strings[i];
    if ((i % 13) == 0) {
        resultBuilder.append(s);
    } else {
        resultBuilder.append(s).append("\n");
    }
}
String result = resultBuilder.toString();