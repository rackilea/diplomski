public class Test extends JFrame {
    public Test() {
        getContentPane().setLayout(new FlowLayout());
        final JComboBox<String> jcbSource = new JComboBox<String>();
        jcbSource.setSize(new Dimension(30, 20));
        add(jcbSource);

        JButton setupButton = new JButton("Setup model");
        setupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> al = new ArrayList<String>();
                al.add("A");
                al.add("B");
                al.add("C");
                al.add("D");
                al.add("E");

                String[] items = new String[al.size()];
                al.toArray(items);

                jcbSource.setModel(new DefaultComboBoxModel<String>(items));
            }
        });
        add(setupButton);

        pack();
    }

    public static void main(String[] args){
        new Test().setVisible(true);
    }
}