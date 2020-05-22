public static void main(String[] args) throws Exception {
    String receivedFromPHP = "Student ID;Student Name;Test Assignment;Secondary Test Assignment;\n"
            + "1;Luc;Test assignment 1;Secondary Test assignment 1;\n"
            + "2;Vador;Test assignment 2;Secondary Test assignment 2;";

    BufferedReader br = new BufferedReader(new StringReader(receivedFromPHP));
    // For real: br = new BufferedReader(new InputStreamReader(new URL("http://localhost/yourPhpPage.php").openStream()));

    DefaultTableModel dtm = new DefaultTableModel();

    String line;
    boolean headersReceived = false;
    while ((line = br.readLine()) != null) {
        String[] columns = line.split(";");
        if (!headersReceived) {

            dtm.setColumnIdentifiers(columns);
            headersReceived = true;
        } else {
            dtm.addRow(columns);
        }
    }

    JTable table = new JTable(dtm);
    JFrame f = new JFrame();
    f.add(new JScrollPane(table));
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}