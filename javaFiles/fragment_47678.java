JFileChooser jfc = new JFileChooser();
File[] files = jfc.getSelectedFiles();
jfc.setMultiSelectionEnabled(true);
jfc.showOpenDialog(null);

if ( files != null && files.length > 0) {
    for ( File file : files ) {
        layoutmanager.add(new JButton("Filename")); // Or anything else you want to do with the files/buttons
    }
}