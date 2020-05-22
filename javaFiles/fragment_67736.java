//create files
File original =new File("C:\\test\\testfile.txt");
File destination =new File("D:\\test\\file.txt");
//check if file exists.
for(int x=0;destination.exists()==true;x++){
//if file exists then add 1 to file name and check if exists again.
destination=new File("D\\test\\file"+x+".txt");

}
//copy file.
Files.copy(origional, destination, StandardCopyOption.REPLACE_EXISTING);