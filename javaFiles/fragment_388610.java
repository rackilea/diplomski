public class Test{
public static void main(String args[]) {
      Scanner lineSeperator = new Scanner("5005,Black Lizards,USA");
         lineSeperator.useDelimiter(",");
         while(lineSeperator.hasNext())
         System.out.println(lineSeperator.next());

  }
}