spinner.addChangeListener(new ChangeListener() {

   @Override
   public void stateChanged(ChangeEvent e) {

    try {
       String colorString = (String)spinner.getValue();

       Field field = Class.forName("java.awt.Color").getField(colorString.toLowerCase()); // toLowerCase because the color fields are RED or red, not Red
       Color color = (Color)field.get(null);

       JTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
       tf.setForeground(color);

       } catch (Exception ex) { // handle ex }
   }
});