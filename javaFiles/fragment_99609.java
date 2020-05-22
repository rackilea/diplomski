private JFrame frame = new JFrame("Image JFrame");
 JLabel lbl = null;

 public void displayImage(Image img2){   

    if(lbl==null){
       lbl = new JLabel();

       frame.setLayout(new FlowLayout());    
       frame.setSize(img2.getWidth(null)+50, img2.getHeight(null)+50);     

       frame.add(lbl);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    ImageIcon icon=new ImageIcon(img2);
    lbl.setIcon(icon);  

}