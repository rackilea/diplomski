import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class Scheduler2 extends JPanel {
    private static final Employee2[] employees = { 
            new Employee2("Amanda", 0, false), 
            new Employee2("Austin", 0, false),
            new Employee2("Conner", 0, false), 
            new Employee2("Faith", 0, false), 
            new Employee2("Jospeh", 0, false),
            new Employee2("Lexi", 0, false), 
            new Employee2("Matthew", 0, false), 
            new Employee2("Samie", 0, false),
            new Employee2("Tanner", 0, false), 
            new Employee2("Valeire", 0, false), 
            new Employee2("Will", 0, false),
            new Employee2("Zack", 0, false) };
    private static final String[] WEEK_DAYS = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

    // associates each list with the day of the week
    private Map<String, JList<Employee2>> weekDayListMap = new HashMap<>();

    public Scheduler2() {
        // layout to hold 1 row, multiple columns
        setLayout(new GridLayout(1, 0));
        // renderer that shows employee names only
        EmployeeCellRenderer cellRenderer = new EmployeeCellRenderer();
        for (int i = 0; i < WEEK_DAYS.length; i++) {
            // new model for each week
            DefaultListModel<Employee2> listModel = new DefaultListModel<>();
            for (Employee2 employee : employees) {
                // fill the model
                listModel.addElement(employee);
            }
            // new list for each day of the week with model
            JList<Employee2> list = new JList<>(listModel);
            list.setVisibleRowCount(4);
            list.setCellRenderer(cellRenderer); // so shows name only
            String prototypeName = "aaaaaaaaaaaaaaaaaaa";
            list.setPrototypeCellValue(new Employee2(prototypeName, 0, false));
            weekDayListMap.put(WEEK_DAYS[i], list); // put in collection (if needed)
            JScrollPane scrollPane = new JScrollPane(list);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            // if we want a border around the jscrollpane showing the day of the week
            JPanel container = new JPanel(new BorderLayout());
            container.add(scrollPane);
            container.setBorder(BorderFactory.createTitledBorder(WEEK_DAYS[i]));
            add(container);
        }
    }

    // JList renderer to display only names
    private class EmployeeCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
            if (value == null) {
                value = "";
            } else {
                Employee2 empl = (Employee2) value;
                value = empl.getName();
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Scheduler2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Scheduler2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}