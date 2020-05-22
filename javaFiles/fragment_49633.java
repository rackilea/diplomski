public class Test
{
    public static void main( String... args )
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance( Items.class );
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Items itResult =  (Items) jaxbUnmarshaller.unmarshal( new File( "Items.xml" ) );

            if ( itResult != null )
            {
                List<Item> items = itResult.getItemList();
                for ( Item item : items )
                {
                    System.out.println( item.getName() );
                }
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

}