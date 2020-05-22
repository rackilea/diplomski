JTable myTable; 
public void actionPerformed(ActionEvent e) {
    try {
        TableModel model = myTable.getModel(); // the table model contains all the data. Read its JavaDoc API it is enlightend when you work with JTables and you can do lots of neat stuff with it.
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) { // no save when the user canceled.
            File target = fc.getSelectedFile();
            FileWriter fWri = new FileWriter(target); // this will create the file, but not any parent directories that might not exist. If there are parent directories that don't exist, this line will throw a FileNotFoundException.
            for(int ii = 0; ii < model.getRowCount(); ii++) {
                StringBuilder lineValue = new StringBuilder();
                for(int jj = 0; ii < model.getColumnCount(); jj++) {
                    lineValue.append(model.getValueAt(ii, jj));
                    lineValue.append(",");
                }
                lineValue.substring(0, lineValue.length() -1); // cut away the last ,
                fWri.write(lineValue + "\r\n"); // the RFC suggests CRLF, but don't be surprised when you get a CSV from somewhere that has only LF or something. Its because of lines like this that you want a library handle it for you.
            }
            fWri.flush();// in fact, this and the next line should go to a 'finally' block. Read about correct and clean file writing to learn more.
            fWri.close();
        }
    } catch (IOException ioex) {
         // file not found, cant be written to, etc. You handle it here.
    }
}