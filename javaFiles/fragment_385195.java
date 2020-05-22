public class ListDemo extends JFrame{

    private DefaultListModel<Integer> listModel1 = new DefaultListModel<>();
    private DefaultListModel<String> listModel2 = new DefaultListModel<>();
    private JList<Integer> list1 = new JList<>(listModel1);
    private JList<String> list2 = new JList<>(listModel2);
    int size = 101;

    public ListDemo() {

        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list1));

        list2.addListSelectionListener(new ListParityFilter());
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listModel2.addElement("All");
        listModel2.addElement("Even");
        listModel2.addElement("Odd");
        list2.setSelectedIndex(0);
        add(new JScrollPane(list2), BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ListParityFilter implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {

            if (e.getValueIsAdjusting())
                return;
            System.out.println("Selected List2 item: " + list2.getSelectedValue());
            listModel1.clear();
            switch (list2.getSelectedIndex()) {
                case 0:
                    for (int i = 0; i < size; i++)
                        listModel1.addElement(i);
                    break;
                case 1:
                    for (int i = 0; i < size; i += 2)
                        listModel1.addElement(i);
                    break;
                case 2:
                    for (int i = 1; i < size; i += 2)
                        listModel1.addElement(i);
                    break;
            }
        }
    }

    public static void main(String[] args) {

        new ListDemo();
    }
}