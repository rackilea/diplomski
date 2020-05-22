Elements body = doc.getElementsByClass( "field-content" );

for( Element link : body )
{
    System.out.println( link.text() );
}