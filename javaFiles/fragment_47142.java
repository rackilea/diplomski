menuItem = new JMenuItem("Document");
    menuItem.addActionListener(new ActionListener()
            menuItem.addActionListener(new ActionListener()   //You don't need it again.
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            System.out.println("button clicked!");
                        }
                    });
    submenu.add(menuItem);