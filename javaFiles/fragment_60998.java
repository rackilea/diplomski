public void actionPerformed(ActionEvent e) {
    JButton pressedButton = (JButton)e.getSource();
    if(pressedButton.getBackground() == Color.GREEN){ 
       pressedButton.setBackground(Color.WHITE); 
    }else if(pressedButton.getBackground() == Color.WHITE){ 
       pressedButton.setBackground(Color.GREEN); 
    }else{ 
       pressedButton.setBackground(Color.WHITE); 
    } 
}