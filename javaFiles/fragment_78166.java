import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.sound.midi.Sequence;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CustomSwingWorker extends SwingWorker<TableModel, Void> {

    private File file;
    private JTable table;

    public CustomSwingWorker(final JTable table, final File file) {
        this.table = table;
        this.file = file;
    }

    @Override
    protected TableModel doInBackground() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        String result = "";
        while ((line = in.readLine()) != null) {
            if (!line.startsWith(">")) {
                result = result + line;
            }
        }

        Sequence sequence = new Sequence("Unspecified", result);
        ArrayList<Contig> contigs = sequence.getReadingFrames();

        String [] columnNames = {"Position", "Frame", "Sequence"};

        Object[][] data = new Object[contigs.size()][3];
        int j = 0;
        for (int i = 0; i <= contigs.size() && j < 3; i++) {
            if (i == contigs.size()) {
                j++;
                i = -1;
            } else if (j == 0) {
                data[i][j] = Integer
                        .toString(contigs.get(i).getStartPosition());
            } else if (j == 1) {
                data[i][j] = Integer.toString(contigs.get(i).getReadingFrame());
            } else if (j == 2) {
                data[i][j] = contigs.get(i).getSequence();
            }
        }

        in.close();
        return new DefaultTableModel(data, columnNames);
    }

    protected void done() {
        try {
            this.table.setModel(this.get());
        } catch (Exception ignore) {
            // Simply ignore it ...
        }
    }
}