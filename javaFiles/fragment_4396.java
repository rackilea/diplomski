import java.io.File;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class BackupBackgroundProcess extends SwingWorker<Object, String> {

    public BackupBackgroundProcess() {
    }

    @Override
    protected void process(List<String> list) {
        System.out.println("PROCESSING " + list.size() + " files");
    }

    @Override
    protected void done() {
    }

    @Override
    protected Object doInBackground() throws Exception {
        System.out.println("OK");
        File[] root;
        root = new File("/home/hilman/Pictures/err").listFiles();
        for (File file : root) {
            seekFiles(file, this);
        }
        return null;
    }

    private void seekFiles(File f, SwingWorker thread) {
        if (f.isDirectory()) {
            File[] listedFiles = f.listFiles();
            for (int i = 0; i < listedFiles.length; i++) {
                File file = listedFiles[i];
                seekFiles(file, thread);
            }
        } else {
            //          System.out.println(" PUBLISHING FILE " + f.getAbsolutePath());
            publish(f.getAbsolutePath());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new BackupBackgroundProcess().execute();
            }
        });

    }
}