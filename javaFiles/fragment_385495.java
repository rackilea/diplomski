File file = new File(uri.getPath());
file.delete();
if(file.exists()){
      file.getCanonicalFile().delete();
      if(file.exists()){
           getApplicationContext().deleteFile(file.getName());
      }
}