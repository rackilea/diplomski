import java.awt.*
import groovy.swing.*

sb = new SwingBuilder()
sb.build {
  f = frame(pack:true) {
      label "<html>" + (("This is a very long label."*3) + "<BR>")*5
  }
  Point cp = GraphicsEnvironment.localGraphicsEnvironment.centerPoint
  f.location = new Point((int)(cp.x - f.width), (int) (cp.y - f.height))
  f.show()
}