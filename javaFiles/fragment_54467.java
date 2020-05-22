String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Android";
Log.d("Files", "Path: " + path);
File directory = new File(path);
File[] files = directory.listFiles();
if (files != null)
{
   Log.d("Files", "Size: "+ files.length);
   for (int i = 0; i < files.length; i++)
   {
       Log.d("Files", "FileName:" + files[i].getName());
   }
}