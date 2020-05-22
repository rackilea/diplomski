public class StartPanel extends JPanel{

private BufferedImage virus;
private BufferedImage ecoli;

boolean pic1;


public StartPanel(){

    try{
       virus = ImageIO.read(new File("PathtoImage"));
       ecoli = ImageIO.read(new File("PathtoImage"));
    }
    catch (IOException ex){
        System.out.println("Error ;-)");
    }

    this.setLayout(null);
    this.add(Button());
    pic1 = true;

}

private JButton Button(){
    JButton b = new JButton("a");
    b.setBounds(230,480,20,20);
    b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
            pic1 = !pic1;
            repaint();
        }
    });
    return b;
}

protected void paintComponent(Graphics g){
    if(pic1)
        g.drawImage(ecoli,0,0,this);
    else
        g.drawImage(virus,0,0,this);
}

}