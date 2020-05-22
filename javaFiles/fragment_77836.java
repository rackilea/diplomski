radioStock.addActionListener(new ActionListener() 
    {
    @Override
    public void actionPerformed(ActionEvent e) 
    {
         if(radioStock == e.getSource()) 
         {
            stockField.setEnabled(radioStock.isSelected());
         }
       }
    });