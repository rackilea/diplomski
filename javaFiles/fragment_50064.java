import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RecursiveFileIterable implements Iterable<File> {
    private File file;

    public RecursiveFileIterable(File f) {
        file = f;
    }

    public RecursiveFileIterable(String filename) {
        this(new File(filename));
    }

    private class DirectoriesOnlyFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }

    }

    private class NoDirectoriesFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            return !pathname.isDirectory();
        }
    }

    @Override
    public Iterator<File> iterator() {
        List<File> normFiles = Arrays.asList(file
                .listFiles(new NoDirectoriesFilter()));
        ArrayList<Iterable<File>> pendingIterables = new ArrayList<Iterable<File>>();
        pendingIterables.add(normFiles);

        File[] subdirs = file.listFiles(new DirectoriesOnlyFilter());
        for (File sd : subdirs)
            pendingIterables.add(new RecursiveFileIterable(sd));

        return new FlattenIterable<File>(pendingIterables).iterator();

    }

}