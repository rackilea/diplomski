String extension = "";

int i = fileName.lastIndexOf('.');
if (i > 0) {
extension = fileName.substring(i+1);
}