if (option == JOptionPane.OK_OPTION) {
        String value1 = fullName.getText();
        String value2 = section.getText();

        String outputStr = "Name: " + value1 + "\n" + "Section: " + value2;

        JOptionPane.showMessageDialog(null, outputStr, "User Information",
            JOptionPane.INFORMATION_MESSAGE);
    }