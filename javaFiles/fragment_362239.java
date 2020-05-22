URL url1 = new URL("http://path/file1.txt");
URL url2 = new URL("http://path/file2.txt");
InputStream is1 = url1.openStream();
InputStream is2 = url2.openStream();
if( IOUtils.contentEquals( is1, is2 ) )
{
  //the same content
}