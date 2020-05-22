JFileChooser chooser = new JFileChooser();
chooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
    System.out.println("You chose to open file: " + chooser.getSelectedFile().getName());
    ArrayList<String> rowData = new FileConnections().read(chooser.getSelectedFile());
}