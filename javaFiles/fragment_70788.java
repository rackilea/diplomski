String location = "url-of-webpage-A"
String pageContent = new URL( location ).openConnection().with { con ->
  // We'll do redirects ourselves
  con.instanceFollowRedirects = false

  // Get the location to jump to (in case of a redirect)
  location = con.getHeaderField( "Location" )

  // Read the HTML and close the inputstream
  con.inputStream.withReader { it.text }
}

if( location ) { 
  println "Page wanted to redirect to $location"
}
println "Content was:"
println pageContent