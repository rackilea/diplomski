final JTextField abc = new JTextField(" (Must be 6-15 characters)");         
    abc.setBounds(40,130,310,30);
    abc.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
    abc.setForeground(Color.gray);                          
    abc.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            abc.setText("");
        }
    });
    mainPanel.add(abc);