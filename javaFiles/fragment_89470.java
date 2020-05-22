class T extends JFrame {

public T() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    String s1 = "Started at: 2011-09-12 15:33:38";
    String s2 = "Last updated: 2011-09-12 15:33:44";
    String s3 = "File copied:2/10";
    String s4 = "Bytes copied: 234/1000";
    String s5 = "ETC: 2011-09-02 15:34:02";
    JProgressBar progressBar = new JProgressBar();

    progressBar.setMinimum(100);
    progressBar.setStringPainted(true);
    progressBar.setString("23%");
    progressBar.setValue(23);

    setLayout(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();

    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 1.0;
    c.insets = new Insets(5, 5, 5, 5);
    add(new JLabel(s1), c);

    c.gridx = 2;
    add(new JLabel(s2, JLabel.RIGHT), c);

    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth = 3;
    add(progressBar, c);

    c.gridx = 3;
    add(new JButton("Clear"), c);

    c.gridx = 0;
    c.gridy = 2;
    add(new JLabel(s3), c);

    c.gridx = 0;
    add(new JLabel(s4, JLabel.CENTER), c);

    c.gridx = 2;
    add(new JLabel(s5, JLabel.RIGHT), c);

    setSize(600, 300);
    setVisible(true);

}

public static void main(String[] args) {
    new T();
}