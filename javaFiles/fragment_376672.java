JFileChooser chooser = new JFileChooser();
FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
chooser.setFileFilter(filter);
int returnVal = chooser.showOpenDialog(null);
if(returnVal == JFileChooser.APPROVE_OPTION)
{
    System.out.println("You chose to open file: " + chooser.getSelectedFile().getName());
    ArrayList<String> rowData = new ArrayList<String>();
    FileConnections excelConn = new FileConnections();
    rowData = excelConn.read(chooser.getSelectedFile());
}