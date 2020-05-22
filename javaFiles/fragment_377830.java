private boolean  isFileNameValid(final Part part) {
final String partHeader = part.getHeader("content-disposition");
String fileName="";
for (String content : part.getHeader("content-disposition").split(";")) {
    if (content.trim().startsWith("filename")) {
        fileName=content.substring(
                content.indexOf('=') + 1).trim().replace("\"", "");
    }
 }
  if(fileName.contains(".jpg")){// Similarly for all extension type.
    return true;
 }
 else{
    return false
 }
}