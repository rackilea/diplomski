JOptionPane jopt = new JOptionPane();
    String result;
    result = "your message";
    JLabel resLabel = new JLabel(result);
    resLabel.setFont(new Font("Monospaced", Font.BOLD, 50));
    jopt.showMessageDialog( null, resLabel, "Results", JOptionPane.PLAIN_MESSAGE );