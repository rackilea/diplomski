String fileName = listOfFiles[i].getName();
int index = fileName.lastIndexOf('.');
if (index >= 0) {
    fileName = fileName.substring(0,  index);
}
System.out.println(fileName);