menuItem = new JMenuItem("Document");
    menuItem.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            System.out.println("button clicked!");
                        }
                    });
    submenu.add(menuItem);