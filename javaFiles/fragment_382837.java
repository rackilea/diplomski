InputStream fis = 
    new FileInputStream(new File("src/config/ehcache.xml").getAbsolutePath());
try 
{
  CacheManager manager = new CacheManager(fis);
} 
finally 
{
  fis.close();
}