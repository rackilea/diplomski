int selectedRow = tblJournalBatchList.getSelectedRow();

if ((String)tblJournalBatchList.getValueAt(selectedRow, 3).equals("NO")) {

    btnPost.setEnabled(false);

}