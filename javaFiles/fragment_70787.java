String location = "url-of-webpage-A"
boolean wasRedirected = false
String pageContent = null

while( location ) {
  new URL( location ).openConnection().with { con ->
    // We'll do redirects ourselves
    con.instanceFollowRedirects = false

    // Get the response code, and the location to jump to (in case of a redirect)
    location = con.getHeaderField( "Location" )
    if( !wasRedirected && location ) {
      wasRedirected = true
    }

    // Read the HTML and close the inputstream
    pageContent = con.inputStream.withReader { it.text }
  }
}

println "wasRedirected:$wasRedirected contentLength:${pageContent.length()}"