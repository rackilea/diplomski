try
{
  File file = File.createTempFile("abc", null);
  System.out.println(file.getPath());
  System.out.println(file.getCanonicalPath());
}
catch (IOException e) {}