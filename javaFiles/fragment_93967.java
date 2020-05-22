private String getFolderPath(){

File StorageDirectory = Environment.getExternalStorageDirectory();
String StorageDownloads = StorageDirectory.getAbsolutePath() + "/Download";
return StorageDownloads;

}