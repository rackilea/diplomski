Button b = ...;
b.addActionListener(new ActionListener() {
    ....
}); 

ActionListener[] listeners = b.getActionListeners();
for (ActionListener listener : listeners) {
    System.out.println(listener.getClass());  // Prints the reference to the class
}