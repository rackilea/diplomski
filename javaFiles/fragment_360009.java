String fileName = "test.txt";

String extension = "";
String name = "";

int idxOfDot = fileName.lastIndexOf('.');   //Get the last index of . to separate extension
extension = fileName.substring(idxOfDot + 1);
name = fileName.substring(0, idxOfDot);

Path path = Paths.get(fileName);
int counter = 1;
File f = null;
while(Files.exists(path)){
    fileName = name+"("+counter+")."+extension;
    path = Paths.get(fileName);
    counter++;
}
f = new File(fileName);