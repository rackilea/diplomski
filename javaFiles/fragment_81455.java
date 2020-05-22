import static java.nio.file.StandardOpenOption.*;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MergeFiles
{
  public static void main(String[] arg) throws IOException {
    if(arg.length<2) {
      System.err.println("Syntax: infiles... outfile");
      System.exit(1);
    }
    Path outFile=Paths.get(arg[arg.length-1]);
    System.out.println("TO "+outFile);
    try(FileChannel out=FileChannel.open(outFile, CREATE, WRITE)) {
      for(int ix=0, n=arg.length-1; ix<n; ix++) {
        Path inFile=Paths.get(arg[ix]);
        System.out.println(inFile+"...");
        try(FileChannel in=FileChannel.open(inFile, READ)) {
          for(long p=0, l=in.size(); p<l; )
            p+=in.transferTo(p, l-p, out);
        }
      }
    }
    System.out.println("DONE.");
  }
}