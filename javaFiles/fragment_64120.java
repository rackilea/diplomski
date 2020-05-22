import edu.stanford.nlp.io.*;
import edu.stanford.nlp.util.*;

import java.util.*;

public class ReadFiles {

  public static void main(String[] args) {

    List<String> filePaths = IOUtils.linesFromFile(args[0]);
    for (String filePath : filePaths) {
      String fileContents = IOUtils.stringFromFile(filePath);
    }
  }
}