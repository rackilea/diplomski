I got the code.I hope it would be useful.here is my modified code.Thank you vishal.


     JButton testButton=new JButton("test");
                        toolBar.addComponentRight(testButton);
                        testButton.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {


           JOptionPane.showConfirmDialog((Component) null, "Do you want to close ?", "Window Title", JOptionPane.OK_CANCEL_OPTION);
    }
    });