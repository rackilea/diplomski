NodeList stockList = eElement.getElementsByTagName("Stock");
for ( int i = 0; i < stockList.getLength(); i++ )
{
   Node stockNode = stockList.item(i);
   if ( stockNode.getNodeType() == Node.ELEMENT_NODE )
   {
       Element stockElement = (Element)stockNode;
       System.out.println( "Warehouse name : " + stockElement.getAttribute( "Warehouse_name" ) );
       System.out.println( "Availability : " + stockElement.getAttribute( "Availability" ) );
    }
}