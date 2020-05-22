@Override
public void actionPerformed(ActionEvent e) {
    String strInput = CreateTextbox.this.stringEntry.getText();
    String strDate = CreateTextbox.this.dateEntry.getText();
    valiDate(strDate);
}