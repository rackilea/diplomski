String j = txtAge.getText();
try { 
    Integer i = Integer.parseInt(txtAge);
}
catch (NumberFormatException e) { 
    // j isn't a number...
}