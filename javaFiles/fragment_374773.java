InputStream in = s3Object.getObjectContent();
byte[] buf = new byte[1024];
OutputStream out = new FileOutputStream(file);
while( (count = in.read(buf)) != -1)
{
   if( Thread.interrupted() )
   {
       throw new InterruptedException();
   }
   out.write(buf, 0, count);
}
out.close();
in.close();