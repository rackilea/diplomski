Bitmap bitmap = null;
    URL imageUrl = new URL(url);
    HttpURLConnection conn = (HttpURLConnection)imageUrl.openConnection();
    conn.setConnectTimeout(30000);
    conn.setReadTimeout(30000);
    InputStream is = conn.getInputStream();
    OutputStream os = new FileOutputStream(f);

try
{
   byte[] bytes=new byte[1024];
   for(;;)
   {
      int count=is.read(bytes, 0, 1024);
      if(count==-1)
         break;
      os.write(bytes, 0, count);
    }
 }
 catch(Exception ex){}
os.close();
bitmap = decodeFile(f);