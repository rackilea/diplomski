class ReadWriteTableData {
    private JTable table;

    public ReadWriteTableData(JTable table) {
        this.table = table;
    }

    public void read(File file) throws FileNotFoundException {
        MyTableModel tableModel = (MyTableModel) table.getModel();
        tableModel.setRowCount(0);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] tokens = line.split("\\|");
                String[] trimmedTokens = new String[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    String text = tokens[i];
                    if (text == null || text.trim().equals("null")) {
                        text = "";
                    } else {
                        text = text.trim();
                    }
                    trimmedTokens[i] = text;
                }
                tableModel.addRow(trimmedTokens);
            }
        }
        table.setModel(tableModel);
        scanner.close();
    }

    public void write(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        Formatter formatter = new Formatter(fileWriter);
        MyTableModel model = (MyTableModel) table.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++) {
                String value = (String) model.getValueAt(row, col);
                value = value == null ? "" : value;
                formatter.format("%25s ", value);
                if (col != model.getColumnCount() - 1) {
                    formatter.format(" | ");
                }
            }
            formatter.format("%n");
        }
        if (formatter != null) {
            formatter.close();
        }        
    }

}