// from the JOptionPane API
 Object[] possibleValues = { "First", "Second", "Third" };

 Object selectedValue = JOptionPane.showInputDialog(null,
             "Choose one", "Input",
             JOptionPane.INFORMATION_MESSAGE, null,
             possibleValues, possibleValues[0]);