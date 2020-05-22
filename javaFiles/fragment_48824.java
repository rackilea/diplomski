import java.awt.*; 
import javax.swing.*; 

@SuppressWarnings("serial")
public class ShowPNG extends JFrame
{    
  private ShowPNG(String arg){
      if (arg == null ) {
        arg = "C:/Eclipse/workspace/ShowPNG/bin/a.png";
    }      
    JPanel panel = new JPanel(); 
    panel.setSize(500,640);
    panel.setBackground(Color.CYAN); 
    ImageIcon icon = new ImageIcon(arg); 
    JLabel label = new JLabel(); 
    label.setIcon(icon); 
    panel.add(label);
    this.getContentPane().add(panel); 
  }
  public static void main(String[] args) {
      new ShowPNG(args.length == 0 ? null : args[0]).setVisible(true); 
  }
}