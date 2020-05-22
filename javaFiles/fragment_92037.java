public List<String> getUpnSuffixes( LdapContext ctx, String domainName )
{
   // Domain name should be in DC=you,DC=domain,DC=com format
   String domConfig = "CN=Partitions,CN=Configuration," +domainName ;
   List<String> names = new ArrayList<String>();
   // Dirty hack to get the default suffix
   names.add( domainName.replaceAll( "DC=", "" ).replaceAll( "," , "." );
   // Read the configuration
   Attributes attrs = ctx.getAttributes( domConfig , new String[] { "uPNSuffixes" } );
   Attribute attr = attrs.get( "uPNSuffixes" );
   for ( int i=0; i<attr.size(); i++ )
   {
       names.add( attr.get(i) );
   }
   // Now you have all the suffixes in the "names" list. 
   return names;
}