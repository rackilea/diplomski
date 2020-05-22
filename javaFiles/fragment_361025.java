import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

public class AeroResize extends JFrame {

    public AeroResize(final String title) {

        super(title);
        initUI();
    }

    private void initUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        final JButton minimize = new JButton("Minimize");
        final JButton maximize = new JButton("Maximize");
        final JButton normal = new JButton("Normal");
        add(normal);
        add(minimize);
        add(maximize);
        pack();

        minimize.addActionListener(e -> {
            HWND windowHandle = new HWND(Native.getComponentPointer(AeroResize.this));
            User32.INSTANCE.CloseWindow(windowHandle);
        });
    }

    public static void main(final String[] args) {

        SwingUtilities.invokeLater(() -> new AeroResize("AeroSnap and the Frame State").setVisible(true));
    }
}