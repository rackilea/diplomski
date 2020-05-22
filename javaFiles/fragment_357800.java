try {
    fahrenheit = Double.parseDouble(Temperature_Converter.this.TFFahrenheit.getText());
} catch (NumberFormatException e1) {
     //alert the user       
    JOptionPane.showMessageDialog(null, "You are allowed to introduce numbers only for temperature");
    return;
}