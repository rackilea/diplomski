import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;

import java.util.*;


public class FileScanningTest {

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
            System.err.println(exc);
            return CONTINUE;
        }
    }


    public static void main(String[] args)
            throws IOException {
        boolean recursive = false;
        Path startingDir = Paths.get("/tmp/scanning");
        String pattern = "*.{html,xml}";

        Finder finder = new Finder(pattern);
        if (!recursive) {
            Path dir = startingDir;
            List<File> files = new ArrayList<>();
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{xml,html}")) {
                for (Path entry : stream) {
                    files.add(entry.toFile());
                }

                for (File xmlfile : files) {
                    System.out.println(xmlfile);
                }
            } catch (IOException x) {
                throw new RuntimeException(String.format("error reading folder %s: %s",
                        dir,
                        x.getMessage()),
                        x);
            }
        } else {    
            Files.walkFileTree(startingDir, finder);
            finder.done();
        }

    }
}