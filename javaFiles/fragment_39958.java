private void bSalirActionPerformed(java.awt.event.ActionEvent evt){ 

        int exit = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to exit the application?",
                "Exit Application",
                JOptionPane.YES_NO_OPTION);                             
        if(JOptionPane.YES_OPTION == exit){
             frame.dispose(); // or System.exit(1);
        }
    }