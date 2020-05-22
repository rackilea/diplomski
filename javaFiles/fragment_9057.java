import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class KeyTester {

    static class MyActionListener extends AbstractAction {

        MyActionListener(String str) {

            super(str);

        }

        @Override

        public void actionPerformed(ActionEvent event) {

            System.out.println(getValue(Action.NAME));

        }

    }

    public static void main(String args[]) {

        String aKey = "Action";

        JFrame jFrame = new JFrame("Test");

        JButton jbutton1 = new JButton("<html><center>A<br>Focused/Typed");

        JButton jbutton2 = new JButton("<html><center>Ctlr-Z<br>Window/Pressed");

        JButton jbutton3 = new JButton("<html><center>Shift-L<br>Ancestor/Released");

        Container pane = jFrame.getContentPane();

        pane.add(jbutton1, BorderLayout.NORTH);

        pane.add(jbutton2, BorderLayout.CENTER);

        pane.add(jbutton3, BorderLayout.SOUTH);

        KeyStroke keStroke = KeyStroke.getKeyStroke("typed A");

        Action act = new MyActionListener("Action occured");

        InputMap iMap = jbutton1.getInputMap();


        iMap.put(keStroke, aKey);

        ActionMap actionMap = jbutton1.getActionMap();

        actionMap.put(aKey, act);

        keStroke = KeyStroke.getKeyStroke("ctrl Z");

        act = new MyActionListener("No Action");

        iMap = jbutton2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        iMap.put(keStroke, aKey);

        actionMap = jbutton2.getActionMap();

        actionMap.put(aKey, act);

        keStroke = KeyStroke.getKeyStroke("shift released L");

        act = new MyActionListener("What Happened?");

        iMap = jbutton3.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        iMap.put(keStroke, aKey);

        actionMap = jbutton3.getActionMap();

        actionMap.put(aKey, act);

        jFrame.setSize(200, 200);

        jFrame.show();
    }
}