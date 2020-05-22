@SuppressWarnings("serial")
class ReadModelAction extends AbstractAction {
    private ReadWriteTableData readWriteTableData;
    private TableFun tableFun;

    public ReadModelAction(JTable table, String name, TableFun tableFun) {
        super(name);
        int mnemonic = name.charAt(0);
        putValue(MNEMONIC_KEY, mnemonic);
        readWriteTableData = new ReadWriteTableData(table);
        this.tableFun = tableFun;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = new File(tableFun.getFileName());
        if (!file.exists()) {
            String message = "File " + tableFun.getFileName() + " cannot be found -- aborting read";
            String title = "File Cannot Be Found";
            int optionType = JOptionPane.WARNING_MESSAGE;
            JOptionPane.showMessageDialog(tableFun, message, title, optionType);
            return;
        }
        try {
            readWriteTableData.read(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}