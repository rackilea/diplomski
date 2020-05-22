if (file.isDirectory())//if files is directory
{
    listFile = file.listFiles();
    mFileStrings = new String[listFile.length];

    for (int i = 0; i < listFile.length; i++)
    {
         String fileName=listFile[i]; 
         fileName = fileName.replace(':', '/');
         fileName = fileName.replace('/', '_');
         String loadURL="file://"+Environment.getExternalStorageDirectory()+"/"+folder+"/"+fileName;
         test.add(loadURL);
    }
 }