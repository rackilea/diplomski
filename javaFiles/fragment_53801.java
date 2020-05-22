Field[] robotFields = aRobotClass.getFields();

for (Field field : robotFields) {
   JButton jbutton = new JButton(field.getName());
   //assuming this class implements ActionListener
   jbutton.addActionListener(this);
   // Then assume we have a private class representing a button )
   this.hashMapOrVectorOfButtons.add(new PrivateButton(field));
   jpanel.add(jbutton);
   // etc etc
}