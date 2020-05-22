String filepath = "/Get_file/filename.jpg";
File yourFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + filepath);

if(!yourFile.exists()) {
    yourFile.createNewFile();
} 
FileOutputStream oFile = new FileOutputStream(yourFile, false);