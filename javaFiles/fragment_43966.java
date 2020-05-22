String name = String.valueOf(increase);
File file = new File("E:\\" + name + ".txt");

while(file.exists()){
     increase++;
     // reassign file this while will terminate when #.txt doesnt exist
     name = String.valueOf(increase);
     file = new File("E:\\" + name + ".txt");
} // the while should end here
// then we check again that #.txt doesnt exist and try to create it
if(!file.exists()) {

try {

    String content = textfile.toString();
    file.createNewFile();

    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(content);
    bw.close();

    System.out.println("Done");

}catch (IOException e){
    e.printStackTrace();
}
// you had a extra close bracket here causing the issue
}
// this program will now create a new text file each time its run in ascending order