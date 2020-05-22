import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RetrievePathsOfYesterday {

    public final static void main(String[] args) {
        String pattern = "pnlreport";
        String format = "PDF";
        String baseDir = "F:/Test";
        switch(args.length) {
        case 3:
            format = args[2];
        case 2:
            pattern = args[1];
        case 1:
            baseDir = args[0];
        }
        File root = new File(baseDir);
        File[] customerDirs = root.listFiles(file -> file.getName().toLowerCase(Locale.ENGLISH).startsWith("customer"));
        ArrayList<Path> result = new ArrayList<>();
        for (int i = 0; i < customerDirs.length; i++) {
            result.addAll(getFilesToProcess(customerDirs[i], pattern, format));
        }
        System.out.println(result);
    }

    public static List<Path> getFilesToProcess(File baseDir, String pattern, String format) {
        pattern = pattern.toLowerCase(Locale.ENGLISH);
        format = "." + format.toLowerCase(Locale.ENGLISH);
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_YEAR, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
        File startDir = new File(baseDir, "COB" + sdf.format(now.getTime()));
        ArrayList<Path> result = new ArrayList<>();
        getFilesToProcess(result, startDir, pattern, format);
        return result;
    }

    private static void getFilesToProcess(List<Path> resList, File baseDir, String pattern, String format) {
        System.out.println("processing " + baseDir.getAbsolutePath());
        if (!baseDir.exists()) {
            return;
        }
        File[] files = baseDir.listFiles(pathName -> {
            System.out.println("filter " + pathName.getName());
            if (pathName.isDirectory()) {
                return true;
            }
            if (!pathName.isFile()) {
                return false;
            }
            String name = pathName.getName().toLowerCase(Locale.ENGLISH);
            if (!name.startsWith(pattern)) {
                return false;
            }
            if (!name.endsWith(format)) {
                return false;
            }
            return true;
        });

        for (int i = 0; i < files.length; i++) {
            File current = files[i];
            System.out.println("Checking " + current.getAbsolutePath());
            if (current.isDirectory()) {
                getFilesToProcess(resList, current, pattern, format);
                continue;
            }
            resList.add(Paths.get(current.toURI()));
        }
    }
}