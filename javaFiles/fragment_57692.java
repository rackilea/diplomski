while (res.next())
{
   String output = res.getString(3);
   if ( res.wasNull() )
      System.out.println( "NULL" );
   else
      System.out.println(output);
}