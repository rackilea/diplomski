String url = "http://www.example.com/file.ext?query";
String file = new URL(url).getFile();
String lastFile = file.substring(file.lastIndex('/')+1);
int pos = lastFile.lastIndex('.');
String ext = pos > 0
           ? lastFile.substring(pos + 1) 
           : NONE;