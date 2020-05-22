JLabel iconLabel = new JLabel(image);
...
Timer timer = new Timer(3000, new ActionListener(){
     public void actionPerformed(ActionEvent e) {
         iconLabel.setIcon(image1);
     }
}); 
timer.setRepeats(false);
timer.start();