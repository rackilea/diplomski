import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class abc {

    /**
     * @param args
     * @throws FileNotFoundException
     */
    private static int totalLineCount = 0;
    private static int totalFileScannedCount = 0;

    public static void main(String[] args) throws FileNotFoundException {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("C:" + File.separator));
        chooser.setDialogTitle("FILES ALONG WITH LINE NUMBERS");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Map<String, Integer> result = new HashMap<String, Integer>();
            File directory = new File(chooser.getSelectedFile().getAbsolutePath());

            List<File> files = getFileListing(directory);

            //print out all file names, in the the order of File.compareTo()
            for (File file : files) {
                System.out.println("Directory: "+file);
                result = getFileLineCount(file);
                totalFileScannedCount +=  result.size();
            }


            System.out.println("*****************************************");
            System.out.println("FILE NAME FOLLOWED BY LOC");
            System.out.println("*****************************************");

            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " ==> " + entry.getValue());
            }
            System.out.println("*****************************************");
            System.out.println("SUM OF FILES SCANNED ==>" + "\t" + totalFileScannedCount);
            System.out.println("SUM OF ALL THE LINES ==>" + "\t" + totalLineCount);

        }

    }

    public static Map<String, Integer> getFileLineCount(File directory) throws FileNotFoundException {
        Map<String, Integer> result = new HashMap<String, Integer>();

        File[] files = directory.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File directory, String name) {
                if (name.endsWith(".java")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {
            if (file.isFile()) {
                Scanner scanner = new Scanner(new FileReader(file));
                int lineCount = 0;
                try {
                    for (lineCount = 0; scanner.nextLine() != null; lineCount++);
                } catch (NoSuchElementException e) {
                    result.put(file.getName(), lineCount);
                    totalLineCount += lineCount;
                }
            }
        }

        return result;
    }

    /**
     * Recursively walk a directory tree and return a List of all
     * Files found; the List is sorted using File.compareTo().
     *
     * @param aStartingDir is a valid directory, which can be read.
     */
    static public List<File> getFileListing(
            File aStartingDir) throws FileNotFoundException {
        validateDirectory(aStartingDir);
        List<File> result = getFileListingNoSort(aStartingDir);
        Collections.sort(result);
        return result;
    }

    // PRIVATE //
    static private List<File> getFileListingNoSort(
            File aStartingDir) throws FileNotFoundException {
        List<File> result = new ArrayList<File>();
        File[] filesAndDirs = aStartingDir.listFiles();
        List<File> filesDirs = Arrays.asList(filesAndDirs);
        for (File file : filesDirs) {
            if(file.isDirectory()) {
                result.add(file); 
            }
            if (!file.isFile()) {
                //must be a directory
                //recursive call!
                List<File> deeperList = getFileListingNoSort(file);
                result.addAll(deeperList);
            }
        }
        return result;
    }

    /**
     * Directory is valid if it exists, does not represent a file, and can be read.
     */
    static private void validateDirectory(
            File aDirectory) throws FileNotFoundException {
        if (aDirectory == null) {
            throw new IllegalArgumentException("Directory should not be null.");
        }
        if (!aDirectory.exists()) {
            throw new FileNotFoundException("Directory does not exist: " + aDirectory);
        }
        if (!aDirectory.isDirectory()) {
            throw new IllegalArgumentException("Is not a directory: " + aDirectory);
        }
        if (!aDirectory.canRead()) {
            throw new IllegalArgumentException("Directory cannot be read: " + aDirectory);
        }
    }
}