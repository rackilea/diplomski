import java.io.File;

public class FileDoesNotExistTest {


  public static void main( String[] args ) {
    final boolean result = new File( "test" ).delete();
    System.out.println( "result: |" + result + "|" );
  }
}