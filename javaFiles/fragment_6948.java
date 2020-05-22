import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main2 {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            stringBuilder.append("This is text line.").append(System.lineSeparator());
        }

        JTextArea textArea = new JTextArea();
        textArea.setText(stringBuilder.toString());
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e);

                if((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()) != 0)) {
                    e.consume(); // suppress current event

                    // send new KeyEvent
                    textArea.dispatchEvent(new KeyEvent(textArea, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, (char)KeyEvent.VK_DOWN));
                    textArea.dispatchEvent(new KeyEvent(textArea, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, (char)KeyEvent.VK_DOWN));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e);
            }
        });

        JFrame frame = new JFrame();
        frame.setSize(640, 480);
        frame.getContentPane().add(textArea, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}