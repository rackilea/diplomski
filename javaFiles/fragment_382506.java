public static void main(String[] args) {
    final JFrame frame = new JFrame();

    JButton button = new JButton("hello");
    button.addActionListener(e -> {
        frame.setEnabled(false); // disable main frame
        JOptionPane.showMessageDialog(frame, "hello");
        frame.setEnabled(true); // enable main frame
    });
    frame.setContentPane(button);

    frame.setVisible(true);
    frame.setSize(600, 480);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}