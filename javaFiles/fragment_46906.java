public sampleForm() {
    super("title");
    String[] portNames = SerialPortList.getPortNames();
    comboBox1 = new JComboBox(portNames);
    panel1 = new JPanel(); // default FlowLayout
    panel.add(comboBox1);
    setContentPane(panel1);
}

public static void main(String[] args) {
    sampleForm frame = new sampleForm("sampleForm");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}