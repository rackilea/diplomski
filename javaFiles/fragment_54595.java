//configure the parser to handle your situation
CsvParserSettings settings = new CsvParserSettings();
settings.setUnescapedQuoteHandling(STOP_AT_CLOSING_QUOTE);

//create the parser
CsvParser parser = new CsvParser(settings);

//parse your line
String[] out = parser.parseLine("116,6,2,29 Sep 10,\"\"JJ\" (60 min)\",\"http://www.tvmaze.com/episodes/4855/criminal-minds-6x02-jj\"");

for(String e : out){
    System.out.println(e);
}