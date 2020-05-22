String extension = "";

int i = fileName.lastIndexOf('.');
int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

if (i > p) {
extension = fileName.substring(i+1);
}