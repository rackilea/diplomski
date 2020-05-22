import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FileFinder {

public static class Finder extends SimpleFileVisitor<Path>{
    private final PathMatcher theMatcher;
    ArrayList<File> myFileArray = new ArrayList<File>();

    Finder(String pattern) {
        theMatcher = FileSystems.getDefault().getPathMatcher("glob:"+pattern);
    }

    void find (Path file){
        Path name = file.getFileName();
        if (name != null && theMatcher.matches(name)){
            myFileArray.add(file.toFile());
        }
    }

    File[] returnFileArray(){
        File[] x = new File[myFileArray.size()];
        return myFileArray.toArray(x);
    }

    @Override
    public FileVisitResult visitFile (Path file,BasicFileAttributes attrs){
        find(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs){
        find(dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed (Path file, IOException exc) {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }
}

public static void main(String[] args) throws IOException {
    String startingPoint = "D:\\test"; //Your starting directory
    String findPattern = "*.txt";

    Path startingDir = Paths.get(startingPoint);
    Finder theFinder = new Finder(findPattern);
    Files.walkFileTree(startingDir, theFinder);

        for (File f : theFinder.myFileArray) {
        System.out.println(f.getName());
        }
    }
}