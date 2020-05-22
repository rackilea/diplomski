File file1 = new File(Environment.getExternalStorageDirectory()+"/Testapp/music1.mp3");
File file2 = new File(Environment.getExternalStorageDirectory()+"/Testapp/music2.mp3");
if (file1.exists()) {
 // music1.mp3 present
} else if (file2.exists()) {
 // music2.mp3 present
}