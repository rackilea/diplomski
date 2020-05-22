import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Reader {

    public Reader() {
        // TODO Auto-generated constructor stub
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                                        new FileInputStream("sample.txt")));
            Map<String, Object[]> result = new LinkedHashMap<String, Object[]>();

            while (reader.ready()) {
                String line = reader.readLine();
                String[] values = line.split("\\s+");
                String key = values[0] + "\t" + values[1];

                String label = values[0];
                String date = values[1];
                Integer sum = 0;
                Integer count = 0;
                if (result.containsKey(key)) {
                    sum = (Integer) ((Object[]) result.get(key))[2];
                    count = (Integer) ((Object[]) result.get(key))[3];
                } else {

                }
                result.put(key, new Object[]{label, date,
                        sum + Integer.parseInt(values[2]), count + 1});
            }
            ArrayList arrayList = new ArrayList(result.values());

            /* interate and print new output */
            /*
             * for (String key : result.keySet()) { Integer sum =
             * result.get(key); Integer count = result2.get(key);
             * System.out.println(key + " " + sum + "\t" + count); }
            */
            JTable table = new JTable(new AnimalTableModel(arrayList));
            panel.add(new JScrollPane(table));
            reader.close();
            frame.setContentPane(panel);
            frame.setVisible(true);
            frame.pack();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Reader();
    }

    public class AnimalTableModel implements TableModel {
        final Class[] columnClass = new Class[]{String.class, String.class,
                Integer.class, Integer.class};
        final String[] columnName = new String[]{"Date", "Animal", "Sum",
                "Count"};
        List values = null;

        public AnimalTableModel(List values) {
            this.values = values;
            // initilize values
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClass[columnIndex];
        }

        @Override
        public int getColumnCount() {
            return columnClass.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columnName[columnIndex];
        }

        @Override
        public int getRowCount() {
            return values.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return ((Object[]) values.get(rowIndex))[columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            // TODO FOR EDITABLE DT
        }
    }
}