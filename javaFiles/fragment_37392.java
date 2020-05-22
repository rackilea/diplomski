String s = "[Header: 150,00;20.02.2019;Bemerkung\\]\\;;\\;Andere Bemerkung;]";
List<String> result = new ArrayList<>();
Pattern pattern = Pattern.compile("(?:[^;\\\\]|\\\\.)++");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    result.add(matcher.group(0)); 
} 
System.out.println(result);
// => [[Header: 150,00, 20.02.2019, Bemerkung\]\;, \;Andere Bemerkung, ]]