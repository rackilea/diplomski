public String getDomainFromUpnSuffix( LdapContext ctx, String uPNSuffix )
{
   String filter = "(&(CN=Partitions)(uPNSuffixes=" + uPNSuffix + "))" ;
   // Find the configuration for this suffix
   NamingEnumeration<SearchResult> results = ctx.search( "", filter, null );
   while ( results.hasMore() )
   {
       SearchResult result = results.next();
       return result.getNameInNamespace();
   }
   return null;
}