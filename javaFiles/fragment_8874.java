import java.io.File;

public class Test
{
    public static void main( String args[] )
    {
        File file = new File( "" );
        String tempFile1 = Test.sortThis( file.getPath() );
        System.out.println( tempFile1 );
    }

    public static String sortThis( String inputFileName )
    {
        return inputFileName;
    }
}