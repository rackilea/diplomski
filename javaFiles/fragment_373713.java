object MyStaticObject
{
  lazy val MyStaticValue = {
     // Call a database, read a file included in the Jar, do expensive initialization computation, etc
     4
  }
}