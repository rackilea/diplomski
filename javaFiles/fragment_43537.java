import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        DefaultTableModel model = new DefaultTableModel(0, 10);
        for (int row = 0; row < 10; row++) {
            String[] cols = new String[10];
            for (int col = 0; col < cols.length; col++) {
                cols[col] = row + "x" + col;
            }
            model.addRow(cols);
        }

        try {
            exportTable(new JTable(model), new File("bananas.csv"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void exportTable(JTable myTable, File file) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            StringJoiner sj = new StringJoiner("\t");
            for (int i = 0; i < myTable.getColumnCount(); i++) {
                sj.add(myTable.getColumnName(i));
            }
            bw.write(sj.toString());
            bw.newLine();
            for (int i = 0; i < myTable.getRowCount(); i++) {
                sj = new StringJoiner("\t");
                for (int j = 0; j < myTable.getColumnCount(); j++) {
                    sj.add(myTable.getValueAt(i, j).toString());
                }
                bw.write(sj.toString());
                bw.newLine();
            }
//          JOptionPane.showMessageDialog(rootPane, "Your table have been exported to " + file);
        }
    }

}