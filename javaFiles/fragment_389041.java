// make some sort of constants for all the positions
const int OPEN_PRICE = 0;
const int HIGH_PRICE = 1;
const int LOW_PRICE = 2;
// ....

NodeList nl = parser.parse(null); // you can also filter here

NodeList values = nl.extractAllNodesThatMatch(
  new AndFilter(new TagNameFilter("TD"), 
    new HasAttributeFilter("class", "t1")));

if( values.size() > 0 ) {
  Tag openPrice = values.elementAt(OPEN_PRICE);
  String openPriceValue = openPrice.getText(); // this is the text of the div
}