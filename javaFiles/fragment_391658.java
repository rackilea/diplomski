if (choice == JOptionPane.OK_OPTION) {
        try {
            String inhour = inh.getText();  //-->inhour defined here
            double inhourInput = Double.valueOf(inhour);
        }
        catch (NumberFormatException e) {
            if (inhour == null || inhour.equals("")) {  //-->no scope for inhour
                inhourInput = 0.0;
            }
            else {
                inhourInput = 0.0;
            }
        }