try
{
  InputStream stream = myClass.class.getResourceAsStream("/GeoLite2-City.mmdb");
  DatabaseReader reader = new DatabaseReader.Builder(stream).build();
}
catch (IOException e)
{
  ...
}