httpConn.setInstanceFollowRedirects( false );
httpConn.connect(); 
int responseCode = httpConn.getResponseCode();
while ((responseCode / 100) == 3) { /* codes 3XX are redirections */
   String newLocationHeader = httpConn.getHeaderField( "Location" );
   /* open a new connection and get the content for the URL newLocationHeader */
   /* ... */
   responseCode = httpConn.getResponseCode();
   /* do it until you get some code that is not a redirection */
}