import java.applet.*;
import java.awt.*;

public class FromWhere extends Applet {
  public void init() {
    Label label = new Label(getCodeBase().toString());
    add(label);
 }
}