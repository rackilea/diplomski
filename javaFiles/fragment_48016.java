public void actionPerformed(ActionEvent event){
            String input=event.getActionCommand();
            if(start){
                {
                Image img=new ImageIcon("icon.gif").getImage();
                JButton clicked = (JButton)event.getSource();
                clicked.setText("");
                clicked.setIcon(new ImageIcon(img));
                clicked.setEnabled(false);
                }
            }
        }