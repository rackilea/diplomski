JPanel panel = new JPanel();  // Create and modify this panel
JOptionPane.showOptionDialog(null, 
                             panel, 
                             "Dialog Title", 
                             JOptionPane.DEFAULT_OPTION,
                             JOptionPane.PLAIN_MESSAGE, // NO Icon
                             null, 
                             new Object[] {},  // No options
                             null);