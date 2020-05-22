@Override
public void actionPerformed(ActionEvent e) {
    if(allCheckBoxesSelected){
        allCheckBoxesSelected = false;
        allButton.setText("Select all");
    } else {
        allCheckBoxesSelected = true;
        allButton.setText("Unselect all");
        NodeSelectionCheckBoxJDialog.this.pack();
    }
}