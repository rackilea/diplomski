Correct Answers: 
public static void main(String[] args)
  throws IOException{
 readData(Paths.get("test.txt"));
}

public static void main(String[] args) {
try {
 readData(Paths.get("test"));
 } catch (IOException ex) {
      System.err.println(ex);
 }
}