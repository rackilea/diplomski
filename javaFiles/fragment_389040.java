NodeList nl = parser.parse(null); // you can also filter here

NodeList divs = nl.extractAllNodesThatMatch(
  new AndFilter(new TagNameFilter("DIV"), 
    new HasAttributeFilter("id", "OBJ123")));

if( divs.size() > 0 ) {
  Tag div = divs.elementAt(0);
  String text = div.getText(); // this is the text of the div
}