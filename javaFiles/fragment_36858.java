public class Sample{
  public static void main(String arg[]){
    String filename= "c:\\abc.txt";

    String fileArray[]=filename.split("\\.");

    System.out.println(fileArray[fileArray.length-1]); //Will print the file extension
  }
}