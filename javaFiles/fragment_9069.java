DefaultTableModel dtm = new DefaultTableModel(new String[] { "Column 1" }, 1);
JTable jTable2 = new JTable(dtm) {
    @Override
    public Printable getPrintable(PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat) {
        return new TablePrintable(this, printMode, headerFormat, footerFormat);
    }
};

try{
    jTable2.print(JTable.PrintMode.NORMAL, header, null);
}
catch(java.awt.print.PrinterException e){
    System.out.println("error");
}