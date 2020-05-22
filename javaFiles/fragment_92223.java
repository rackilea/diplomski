//initialize a parser for the pipe separated bit
CsvParserSettings detailSettings = new CsvParserSettings();
detailSettings.getFormat().setDelimiter('=');
detailSettings.getFormat().setLineSeparator("|");
CsvParser detailParser = new CsvParser(detailSettings);

//here is the content of the last column (assuming you got it from the parser)
String details = "destination_ip=192.62.3.74|product_id=0071|option1_type=(s-dns)|proxy_machine_ip=10.1.255.3";

//The result will be a list of pairs
List<String[]> pairs = detailParser.parseAll(new StringReader(details));

//You can add the pairs to a map
Map<String, String> map = new HashMap<String, String>();
for (String[] pair : pairs) {
    map.put(pair[0], pair[1]);
}

//this should print: {destination_ip=192.62.3.74, product_id=0071, proxy_machine_ip=10.1.255.3, option1_type=(s-dns)}
System.out.println(map);