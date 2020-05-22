public class Bouton extends JButton implements MouseListener{
public Bouton(String str, Color bcolornorm, Color bcolorhover, Color bcolorclic){
    super(str);
    this.name = str;
    this.bcolornorm = bcolornorm;
    this.bcolorhover = bcolorhover;
    this.bcolorclic = bcolorclic;
    this.setBackground(this.bcolornorm);
    this.addMouseListener(this);
}
private String name;
public Color bcolornorm;
public Color bcolorhover;
public Color bcolorclic;


public void mouseClicked(MouseEvent event) {}

public void mouseEntered(MouseEvent event) {
    this.setBackground(this.bcolorhover);
}
public void mouseExited(MouseEvent event) {
    this.setBackground(this.bcolornorm);
}
public void mousePressed(MouseEvent event) {
    this.setBackground(this.bcolorclic);
}
public void mouseReleased(MouseEvent event) {
    this.setBackground(this.bcolorhover);
}
}