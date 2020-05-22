JButton listbutton = new JButton("List");
listbutton.setBounds(75, 60, 150, 30);
panel.add(listbutton);
listbutton.addActionListener(new ActionListener()// its listbutton not addbutton
    {
        public void actionPerformed(ActionEvent event) 
            {

                    System.out.println("Author's name: " + newauthor);
                    System.out.println("Book name: " + newbook);
            }
    });