Object[] possibleValues = {"Trails (Broken)", "Invicibility"};
Object selectedValue = JOptionPane.showInputDialog(null,
                "Choose one", "Input",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);

System.out.println(selectedValue);  
if (possibleValues[0].equals(selectedValue)) {
    // Trails (Broken) was selected
    Object[] options = {"True", "False"};
    int result = JOptionPane.showOptionDialog(null, "Press True To Make It True And False For False", (String) possibleValues[0], JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    switch (result) {
        case 0:
            Options.OP_TRAILS = false;
            break;
        case 1:
            Options.OP_TRAILS = false;
            break;
    }
} else if (possibleValues[1].equals(selectedValue)) {
    // Invicibility was selected
}