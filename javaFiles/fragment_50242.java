import javax.swing.*;

public class MyLocation extends JApplet {

    @Override
    public void init() {
        add( new JLabel(getDocumentBase().toString()));
    }
}