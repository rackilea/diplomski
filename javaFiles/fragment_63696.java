public class CodeSample extends JFrame {

private static final long serialVersionUID = -8134989438964195251L;

public CodeSample() {
    JPanel panel = new JPanel();
    setTitle("Memory");
    setContentPane(panel);
    setPreferredSize(new Dimension(300, 300));
    panel.setLayout(new GridLayout(5, 5));
    ButtonListener listener = new ButtonListener();

    JButton[][] buttons = new JButton[5][5];
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            buttons[i][j] = new JButton();
            buttons[i][j].setBackground(Color.black);
            buttons[i][j].putClientProperty("id",
                    String.valueOf(i).concat(String.valueOf(j)));
            buttons[i][j].addActionListener(listener);
            panel.add(buttons[i][j]);
        }
    }

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setVisible(true);
}

public static class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton) e.getSource())
                .getClientProperty("id"));
    }

}

public static void main(String[] args) {
    new CodeSample();
}
}