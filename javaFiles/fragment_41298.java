import javax.swing.*;

public class CreateButton {


    public static class UIFactory {

        public JButton newButton(int posx, int posy, int buttonWidth, int buttonHeight) {
            JButton b = new JButton("Test");
            b.setBounds(posx, posy, buttonWidth, buttonHeight);

            return b;
        }

        public JFrame newFrame(int width, int height) {
            JFrame f = new JFrame();
            f.setSize(width, height);
            f.setLayout(null);

            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            return f;
        }

        public JFrame mainWindow() {
            JFrame f = newFrame(400, 400);
            f.add(newButton(50, 200, 100, 50));
            f.add(newButton(100, 250, 100, 50));
            return f;
        }
    }

    public static void main(String[] args) {
        UIFactory ui = new UIFactory();
        JFrame main  = ui.mainWindow();
        main.setVisible(true);

        JFrame win2 = ui.newFrame(150, 150);
        win2.setLocation(400, 400);
        JButton b2;
        win2.add(b2 = ui.newButton(50, 50, 100, 50));
        b2.addActionListener( e -> win2.setVisible(false) );
        win2.setVisible(true);
    }
}