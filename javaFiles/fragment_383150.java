...
if (s2 != null && s2.length() > 0) {
    boolean isFound = false;
    for (int i = 0; i < str.length; i++) {
        if (s2.equals(str[i].trim())) {
            JOptionPane option = new JOptionPane();
            option.showInputDialog("" + str[i]);
            isFound = true;
            break;
        } 
    }
    if(!isFound) {
        JOptionPane option = new JOptionPane();
        option.showInputDialog("Number Entered is not found in myArray");
    }
} else 
...