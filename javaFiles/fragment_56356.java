public void actionPerformed(ActionEvent e) {
    //Handle open button action.
    if (e.getSource() == openButton) {
        int returnVal = fc.showOpenDialog(FileChooserDemo.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //At this point you can use: file.getName() to get your filename
            //You can also use file.getPath()
        } else {
            //Canceled opening
        }
    }
}