// testDialog is a JDialog field. and this line is called in 
// the class constructor.
JDialog testDialog = new JDialog(theCurrentJFrame, "Dialog Title", false); // true 
                                                                    // if modal

// this line is called in the button's ActionListener.
testDialog.pack(); // Never set the size of your GUI's. 
                   // Let the layout managers do this for you.
testDialog.setVisible(true);