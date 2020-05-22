jj4.addActionListener(new ActionListener()  // jj4-button's reference to implement exit
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(!jtextarea.getText().equals("") && !jtextarea.getText().equals(fileContent))
            {
                if(fileName == null)
                {
                    //this method have 3 options (1 = YES, 2 = NO, 3 = Cancel)
                    option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
                    if(option == 0)
                    {
                        //to save the text into file
                        saveAs();
                        System.exit(0);
                    }
                    if(option == 1)
                    {
                        //to exit the program without saving
                        System.exit(0);
                    }
                }
                else
                {
                    option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
                    if(option == 0)
                    {
                        save();
                        System.exit(0);
                    }
                    if(option == 1)
                    {
                        System.exit(0);
                    }
                }
            }
            else
            {
                System.exit(0);
            }
        }
    });