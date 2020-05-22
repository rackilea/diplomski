try {
   MaskFormatter mascara = new MaskFormatter("##.##");
   JFormattedTextField textField = new JFormattedTextField(mascara);
   textField.setValue(new Float("12.34"));
} catch (Exception e) {
   ...
}