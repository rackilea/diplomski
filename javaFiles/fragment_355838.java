@Override
public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source instanceof CreateTextbox) {
        CreateTextbox instance = (CreateTextbox) source;
        String strInput = instance.getNameText();
        String strDate = instance.getDateText();
        valiDate(strDate);
    }
}