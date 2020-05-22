Pattern ptyy = Pattern.compile("[^\\s|]+(?:\\|[^\\s|])+");
Matcher matcher_values = ptyy.matcher("this is a|b|c|d whatever e|f|g|h");
while (matcher_values.find()) {
    String line = matcher_values.group(0);
    System.out.println(line);
}