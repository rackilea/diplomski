public static void main(String[] args) {

        String dataStr = "rcpt  7554   Jan-21 01-03:43:27       ? /usr/bin/Program\n"
                + "ncuser2  7202   Jan-21 01-04:22:08       ? /usr/bin/Program\n"
                + "lyn  6277   Dec-17 36-02:14:51       ? /usr/bin/Program 10.15.1.104:0.0\n"
                + "lyn  6268   Dec-17 36-02:15:17       ? /usr/bin/Program 10.15.1.104:0.0\n";

        String rows[] = dataStr.split("\n");


        Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
        for (String row : rows) {
            row = row.trim();  //UPDATE
            Vector<String> data = new Vector<String>();
            data.addAll(Arrays.asList(row.split("\\s+")));
            dataVector.add(data);
        }

        Vector<String> header = new Vector<String>(2);
        header.add("User");
        header.add("PID");
        header.add("Launch");
        header.add("Runtime");
        header.add("TTYP");
        header.add("Program");

        TableModel model = new DefaultTableModel(dataVector, header);
        JTable table = new JTable(model);

        JFrame frame = new JFrame("DemoFrame");
        frame.add(new JScrollPane(table));
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }