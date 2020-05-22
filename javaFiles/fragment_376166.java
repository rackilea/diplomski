DefaultHttpClient http = new DefaultHttpClient();
HttpPost post = new HttpPost(strURL);
UsernamePasswordCredentials creds = new UsernamePasswordCredentials(
                    Configuration.username, 
                    Configuration.developerKey);
post.addHeader( BasicScheme.authenticate(creds,"US-ASCII",false) );
StringEntity entity = new StringEntity( ac.toXMLString() );
entity.setContentType("text/xml");
post.setEntity( entity );
org.apache.http.HttpResponse response = http.execute( post );