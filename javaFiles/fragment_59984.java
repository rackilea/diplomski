import com.apple.eawt.Application;
import javax.swing.*;

class SetIcon extends JFrame {

    SetIcon() {
        setIconImage(new ImageIcon("doc.png").getImage());
        Application.getApplication().setDockIconImage(
            new ImageIcon("app.png").getImage());
    }

    public static void main(String args[]) {
        SetIcon s = new SetIcon();
        s.setVisible(true);
    }
}