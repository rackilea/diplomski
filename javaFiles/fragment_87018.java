public JButton createComponentDialogButton() { 
      Action a = new AbstractAction(getString("OptionPaneDemo.componentbutton")) { 
      public void actionPerformed(ActionEvent e) { 
    // In a ComponentDialog, you can show as many message components and 
    // as many options as you want: 

    // Messages 
             Object[]      message = new Object[4]; 
             message[0] = getString("OptionPaneDemo.componentmessage"); 
             message[1] = new JTextField(getString("OptionPaneDemo.componenttextfield")); 

             JComboBox cb = new JComboBox(); 
             cb.addItem(getString("OptionPaneDemo.component_cb1")); 
             cb.addItem(getString("OptionPaneDemo.component_cb2")); 
             cb.addItem(getString("OptionPaneDemo.component_cb3")); 
             message[2] = cb; 

             message[3] = getString("OptionPaneDemo.componentmessage2"); 

    // Options 
             String[] options = { 
        getString("OptionPaneDemo.component_op1"), 
        getString("OptionPaneDemo.component_op2"), 
        getString("OptionPaneDemo.component_op3"), 
        getString("OptionPaneDemo.component_op4"), 
        getString("OptionPaneDemo.component_op5") 
    }; 
             int result = JOptionPane.showOptionDialog( 
        getDemoPanel(),                             // the parent that the dialog blocks 
        message,                                    // the dialog message array 
        getString("OptionPaneDemo.componenttitle"), // the title of the dialog window 
        JOptionPane.DEFAULT_OPTION,                 // option type 
        JOptionPane.INFORMATION_MESSAGE,            
             // message type  null,                                      
            // optional icon, use null to use the default icon options,                                   
            // options string array, will be made into buttons  options[3]                                 


            // option that should be made into a default button 
    ); 
    switch(result) { 
       case 0: // yes 
         JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.component_r1")); 
         break; 
       case 1: // no 
         JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.component_r2")); 
         break; 
       case 2: // maybe 
         JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.component_r3")); 
         break; 
       case 3: // probably 
         JOptionPane.showMessageDialog(getDemoPanel(), getString("OptionPaneDemo.component_r4")); 
         break; 
       default: 
         break; 
    } 

    } 
}; 
return createButton(a); 
 }