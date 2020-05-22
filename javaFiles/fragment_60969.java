File zipFile = new File("/tmp/example.zip");
FileOutputStream fos = null;
try
{
   fos = new FileOutputStream(zipFile);
   ZipOutputStream zos = new ZipOutputStream(fos);

   // ...

   zos.close();
}
catch (IOException ex)
{
   // log/report exception, then delete the invalid file
   IOUtils.closeQuietly(fos);
   zipFile.delete();
}
finally
{
   IOUtils.closeQuietly(fos);
}