public class Field {

    JTextField field = new JTextField();
    static int fieldID = 0;
    private String text;

    public Field() {
        fieldID++;
    }

    public String getValue() {
        return field.getText();
    }

    public void setValue(String text) {
        field.setText(text);
    }
}

public class Frame extends JFrame {

    public Frame() {
        Field[][] fields = new Field[9][9];
        JPanel[] corePane = new JPanel[9];
        JPanel frontPane = new JPanel();
        frontPane.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < corePane.length; i++) {
            corePane[i] = new JPanel();
            fields[i] = new Field[9];
            for (int j = 0; j < 9; j++) {
                fields[i][j] = new Field();
                corePane[i].add(fields[i][j].field);
            }
            corePane[i].setLayout(new GridLayout(3, 3));
            frontPane.add(corePane[i]);
        }

        setLayout(new BorderLayout());
        setSize(300, 300);
        getContentPane().add(frontPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(Frame::new);
    }
}