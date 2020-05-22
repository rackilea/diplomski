File f = new File(getCacheDir()+"/berlin.mp3");
if (!f.exists()) try {
     byte[] buffer = new byte[1024];
     InputStream is = getAssets().open("berlin.mp3");
     FileOutputStream fos = new FileOutputStream(f);
     int len;
     while((len = is.read(buffer)) > 0) 
        fos.write(buffer, 0, len);
} catch (Exception e) { 
     throw new RuntimeException(e); 
} finally {
     IOUtils.close(is); // utility to close the stream properly.
     IOUtils.close(fos);
}