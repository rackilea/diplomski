while (!StringUtils.isNumeric(numberStr) || Integer.parseInt(numberStr) == 0) {

        if (numberStr == null) {
           return 0; 
        }
        else {
            numberStr = JOptionPane.showInputDialog(message);
        }
}