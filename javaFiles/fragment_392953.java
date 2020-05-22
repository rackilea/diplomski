import java.io.*;
import java.nio.file.*;

class Foo {
  public static void main(String[] args) throws Exception {
    Path base = Paths.get("/dir1");
    File f = new File("/dir1/foo/bar/baz");
    System.out.println(base.relativize(f.toPath()));
  }
}