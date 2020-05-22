public class ComboBoxTest {
    private JComboBox comboBox = new JComboBox(
          new DefaultComboBoxModel(new String[] { "Test1", "Test2", "Test3" }));

    public ComboBoxTest() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(200, 100);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                myBox(evt);
            }
        });

        frame.getContentPane().add(comboBox);
        frame.setVisible(true);
    }

    protected void myBox(ActionEvent evt) {
        if (comboBox.getSelectedItem() != null) {
            System.out.println(comboBox.getSelectedItem().toString());
        }
    }
}