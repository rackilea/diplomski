import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import javax.swing.filechooser.FileSystemView;

 public class Find {

private static int finalTotal = 0;

public static class Finder
        extends SimpleFileVisitor<Path> {

    private final PathMatcher matcher;
    private int numMatches = 0;

    Finder(String pattern) {
        matcher = FileSystems.getDefault()
                .getPathMatcher("glob:" + pattern);
    }

    // Compares the glob pattern against
    // the file or directory name.
    void find(Path file) {
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
            numMatches++;
            System.out.println(file);
        }
    }

    // Prints the total number of
    // matches to standard out.
    void done() {
        System.out.println("Matched: "
                + numMatches);
        finalTotal = finalTotal + numMatches;
    }

    // Invoke the pattern matching
    // method on each file.
    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attrs) {
        find(file);
        return CONTINUE;
    }

    // Invoke the pattern matching
    // method on each directory.
    @Override
    public FileVisitResult preVisitDirectory(Path dir,
            BasicFileAttributes attrs) {
        find(dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file,
            IOException exc) {
    //            System.err.println(exc);
        return CONTINUE;
    }
}

public static void main(String[] args)
        throws IOException {

    File[] paths;
    FileSystemView fsv = FileSystemView.getFileSystemView();

    paths = File.listRoots();

    for (File path : paths) {
        String str = path.toString();
        String slash = "\\";

        String s = new StringBuilder(str).append(slash).toString();

        Path startingDir = Paths.get(s);

        String pattern = "*.txt";

        Finder finder = new Finder(pattern);
        Files.walkFileTree(startingDir, finder);
        finder.done();

    }

    System.out.println("Total Matched Number of Files : " + finalTotal);

}