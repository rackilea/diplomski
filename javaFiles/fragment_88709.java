public static void main( String[] args ) throws Exception
{
    Map<Types,Object> map = new HashMap<Types,Object>();

    map.put( AlphaTypes.Common , "b" );
    map.put( BetaTypes.Common , "b" );

    System.out.println( "size=" + map.size());
}