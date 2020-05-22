if (dataStr != null){

    try {
        int data=Integer.parseInt(dataStr);
        JOptionPane.showMessageDialog(null,"Ok"+data);
    } catch (NumberFormatException nfe) {
        // notify user that input was invalid
    }

}