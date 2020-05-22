import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Statistic {

    private static ArrayList<String> rowA = new ArrayList();
    private static ArrayList<String> rowB = new ArrayList();
    private static ArrayList<String> rowC = new ArrayList();
    private static ArrayList<String> titel = new ArrayList();
    private static ArrayList<ArrayList<String>> table = new ArrayList();

    public static void main(String[] args) {

        titel.add("Name");
        titel.add("Art der Bearbeitung");
        titel.add("Datum");

        addRows("buchung", "Created", "10.10.10");
        addRows("buchung", "Created", "10.10.10");
        addRows("buchung", "Created", "10.10.10");
        addRows("buchung", "Created", "10.10.10");
        addRows("buchung", "Created", "10.10.10");

        table.add(rowA);
        table.add(rowB);
        table.add(rowC);

          Object[] tempTitel = titel.toArray();
          String[][] tempTable = new String[table.size()][];
       int i = 0;
       for (List<String> next : table) {
       tempTable[i++] = next.toArray(new String[next.size()]);
        }

       JTable EndTable = new JTable(tempTable,tempTitel);

        JFrame frame = new JFrame("Demo");
        frame.getContentPane().add(new JScrollPane(EndTable));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void addRows(String rowa, String rowb, String rowc) {

        rowA.add(rowa);
        rowB.add(rowb);
        rowC.add(rowc);

    }

}