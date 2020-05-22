/**
 * @see http://stackoverflow.com/a/16587357/230513
 */
public class ListListenerTest {

    private static final String[] items = new String[]{"1", "2", "3"};
    private JComboBox combo = new JComboBox(items);
    private JList list = new JList(new MyModel(combo));

    private static class MyModel extends DefaultListModel implements ActionListener {

        private JComboBox combo;

        public MyModel(JComboBox combo) {
            this.combo = combo;
            addElement(combo.getSelectedItem());
            combo.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            set(0, combo.getSelectedItem());
            System.out.println("Combo changed.");
        }
    }

    private void display() {
        JFrame f = new JFrame("ListListenerTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(1, 0));
        f.add(combo);
        f.add(list);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListListenerTest().display();
            }
        });
    }
}