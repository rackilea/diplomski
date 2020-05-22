//you can do
    JTextField field1 = new JPasswordField(); //child is an instance of parent
    JTextField field2 = new MyJTextField(); //child is an instance of parent

    //you can't do
    JPasswordField field3 = new JTextField(); // parent is not instance of child
    MyJTextField field4 = new JTextField(); // parent is not instance of child
    JPasswordField field5 = new MyJTextField(); // siblings are not instances of each other
    MyJTextField field6 = new JPasswordField(); // siblings are not instances of each other