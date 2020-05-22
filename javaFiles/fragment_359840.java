import java.io.*; //import
Scanner scan = null;
try {     //handle exceptions
    File file = new File("woordenlijst.txt");
    scan = new Scanner(file);
 }
catch(FileNotFoundException e) {
    System.out.println(e);

 }
finally {
    scan.close(); // give up the resource.
 }