import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MatrixTransposer {

  private static final String TMP_DIR = System.getProperty("java.io.tmpdir") + "/";
  private static final String EXTENSION = ".matrix.tmp.result";
  private final String original;
  private final String dst;

  public MatrixTransposer(String original, String dst) {
    this.original = original;
    this.dst = dst;
  }

  public void transpose() throws IOException {

    deleteTempFiles();

    int max = 0;

    FileReader fileReader = null;
    BufferedReader reader = null;
    try {
      fileReader = new FileReader(original);
      reader = new BufferedReader(fileReader);
      String row;
      while((row = reader.readLine()) != null) {

        max = appendRow(max, row, 0);
      }
    } finally {
      if (null != reader) reader.close();
      if (null != fileReader) fileReader.close();
    }


    mergeResultingRows(max);
  }

  private void deleteTempFiles() {
    for (String tmp : new File(TMP_DIR).list()) {
      if (tmp.endsWith(EXTENSION)) {
        FileUtils.deleteQuietly(new File(TMP_DIR + "/" + tmp));
      }
    }
  }

  private void mergeResultingRows(int max) throws IOException {

    FileUtils.deleteQuietly(new File(dst));

    FileWriter writer = null;
    BufferedWriter out = null;

    try {
      writer = new FileWriter(new File(dst), true);
      out = new BufferedWriter(writer);
      for (int i = 0; i <= max; i++) {
        out.write(FileUtils.readFileToString(new File(TMP_DIR + i + EXTENSION)) + "\r\n");
      }
    } finally {
      if (null != out) out.close();
      if (null != writer) writer.close();
    }
  }

  private int appendRow(int max, String row, int i) throws IOException {

    for (String element : row.split(" ")) {

      FileWriter writer = null;
      BufferedWriter out = null;
      try {
        writer = new FileWriter(TMP_DIR + i + EXTENSION, true);
        out = new BufferedWriter(writer);
        out.write(columnPrefix(i) + element);
      } finally {
        if (null != out) out.close();
        if (null != writer) writer.close();
      }
      max = Math.max(i++, max);
    }
    return max;
  }

  private String columnPrefix(int i) {

    return (0 == i ? "" : " ");
  }

  public static void main(String[] args) throws IOException {

    new MatrixTransposer("c:/temp/mt/original.txt", "c:/temp/mt/transposed.txt").transpose();
  }
}