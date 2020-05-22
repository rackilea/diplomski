public static void main(String[] args) throws InterruptedException {
    JDialog frame = new JDialog((Frame) null, "MC Immovable");
    frame.setUndecorated(true);
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEtchedBorder(Color.GREEN, Color.RED));
    panel.add(new JLabel("You can't move this"));

    frame.setContentPane(panel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
}