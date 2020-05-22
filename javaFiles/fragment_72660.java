public static void main(String[] args) {
        int choice;
        String menu, choiceStr = "", enterString = "", noSpace;
        String stringWithNoSpaces = "";
        String reversedString = "";

        do {
            menu = "MENU \n"
                    + "(1) Enter a string \n"
                    + "(2) Remove all spaces from a string \n"
                    + "(3) Display the string backward \n"
                    + "(4) Quit";
            choiceStr = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceStr);
            switch (choice) {
                case 1:
                    enterString = JOptionPane.showInputDialog("Please enter the string:");
                    stringWithNoSpaces = enterString;
                    break;
                case 2:
                    stringWithNoSpaces = enterString.replaceAll("\\s", "");                    
                    JOptionPane.showMessageDialog(null, stringWithNoSpaces);
                    break;
                case 3:
                    reversedString = ReverseStr(stringWithNoSpaces);
                    JOptionPane.showMessageDialog(null, reversedString);
                    break;
                case 4:
                    System.exit(0);
            }
        } while (choice != 4);
    }