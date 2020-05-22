import java.awt.Color
import javax.swing.JLabel
import scala.swing._
import scala.util.Random

class MyPanel extends FlowPanel {
    ...
    def drowLabels(size: Int) = {
        for(i <- 0 until size){
            contents += new JLabel()
            revalidate();
            repaint();
         }
    }