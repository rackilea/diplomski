double AllNumbers = 0;
do {

    String ShowSome = JOptionPane.showInputDialog("Enter the amount of numbers you would like to average"); 
    AllNumbers = Double.parseDouble(ShowSome);
} while (AllNumbers < 1);