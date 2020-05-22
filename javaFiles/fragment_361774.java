public void actionPerformed(ActionEvent e) {
    String customer = textField.getText();
    if (map.containsKey(customer)) {
         jta.append(String.valueOf(map.get(customer)));
         jta.append("\n***********************\n\n");
    }
}