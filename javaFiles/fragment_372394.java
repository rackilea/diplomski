import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

public class View extends JFrame {
    public View() {
        super();
        TableModel tableModel = new TableModel();
        JTable testTable = new JTable(tableModel);

        JScrollPane scrollpane = new JScrollPane(testTable);
        // scrollpane.setOpaque(false);
        // scrollpane.getViewport().setOpaque(false);
        JPanel testTablePanel = new JPanel();
        testTablePanel.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createEtchedBorder(), "Testkonfiguration"));
        testTablePanel.setLayout(new BorderLayout());
        testTablePanel.add(scrollpane);

        TableColumn sportColumn = testTable.getColumnModel().getColumn(1);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Snowboarding");
        comboBox.addItem("Rowing");
        comboBox.addItem("Chasing toddlers");
        comboBox.addItem("Speed reading");
        comboBox.addItem("Teaching high school");
        comboBox.addItem("None");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(scrollpane);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new View();
    }

}