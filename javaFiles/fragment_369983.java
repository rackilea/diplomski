private JPanel createContent(){
    //create a anonym class
    @surpress serial
    JPanel panel = new JPanel(){

        @override
        public void paintComponent(Graphics gr){
            super.paintComponent(gr);
            gr.drawImage(img, 0,0, null);
        }

    } 
    panel.setPreferredSize(new Dimension(img.getWidth(), img.getHeight() ));
    return panel;
}