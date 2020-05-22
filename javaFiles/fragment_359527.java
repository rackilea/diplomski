public class TestPane extends JPanel {

    public TestPane() {
        setLayout(new GridLayout(2, 1));

        JPanel fieldPane = new JPanel();
        fieldPane.add(new JTextField(10));
        add(fieldPane);

        JPanel buttonPane = new JPanel();
        buttonPane.add(new JButton("1"));
        buttonPane.add(new JButton("2"));
        buttonPane.add(new JButton("3"));
        add(buttonPane);

    }

}