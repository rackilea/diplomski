List<JTextField> list = new ArrayLists<JTextField>();

// your code...
for (int i=0; i<maxPoints; i++) { 
    JTextField textField = new JTextField();
    points.add(textField);
    list.add( textField ); // keep a reference to those fields.
}