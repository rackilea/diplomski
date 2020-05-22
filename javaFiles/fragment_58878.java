MaskFormatter mask = null;
try {
    mask = new MaskFormatter("##:##:##:###");
} catch (ParseException e) {
    e.printStackTrace();
}
mask.setValidCharacters("0123456789");
mask.setPlaceholderCharacter('0');
JFormattedTextField textField2 = new JFormattedTextField(mask);
textField2.setText("00:00:00:000");