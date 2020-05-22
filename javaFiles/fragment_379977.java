public class Urna extends JFrame {
    public Urna() {
        Container container = getContentPane();
        container.setLayout(<some layout manager that fits your needs>);
        container.add(new TelaVisual());
        container.add(new TelaUrna());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class TelaVisual extends JPanel {
    private JLabel teste = new JLabel();

    public TelaVisual() {
        this.setLayout(new GridLayout(5, 3));

        teste.setText("testando");

        this.add(teste);
    }
}

public class TelaUrna extends JPanel {
    ...
    ...
    ...

    public TelaUrna() {
        // your code here
        // instead of container.something, use this.something
    }
}