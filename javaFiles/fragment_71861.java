@Override
public void actionPerformed(ActionEvent e) {
    int random = (int)(Math.random()*55);
    b1.setIcon(new ImageIcon("image/card/"+random+".png"));
    random = (int)(Math.random()*55);
    b2.setIcon(new ImageIcon("image/card/"+random+".png"));
    random = (int)(Math.random()*55);
    b3.setIcon(new ImageIcon("image/card/"+random+".png"));
    random = (int)(Math.random()*55);
    b4.setIcon(new ImageIcon("image/card/"+random+".png"));
}