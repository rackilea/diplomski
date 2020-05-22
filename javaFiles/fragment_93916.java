public class Main
{
    public static void main(String[] args)
    {
        TestFrame frame = new TestFrame();
        frame.setVisible(true);
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow("SunAwtFrame", "Transparent Window");

        int wl =  User32.INSTANCE.GetWindowLong(hwnd, WinUser.GWL_EXSTYLE);
        wl = wl | 0x80000 | 0x20;
        User32.INSTANCE.SetWindowLong(hwnd, WinUser.GWL_EXSTYLE, wl);
    }

    public static long getHWnd(Frame f) {
        return f.getPeer() != null ? ((WComponentPeer) f.getPeer()).getHWnd() : 0;
    }

    static class TestFrame extends JFrame
    {
        public TestFrame()
        {
            super("Transparent Window");
            setUndecorated(true);
            setBackground(new Color(0, 0, 0, 0));
            setAlwaysOnTop(true);
            setSize(800, 600);
            // Without this, the window is draggable from any non transparent
            // point, including points  inside textboxes.
            getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);

            getContentPane().setLayout(new java.awt.BorderLayout());
            getContentPane().add(new JTextField("text field north"), java.awt.BorderLayout.NORTH);
            getContentPane().add(new JTextField("text field south"), java.awt.BorderLayout.SOUTH);
        }

        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            g.setColor(Color.BLUE);
            g.fill3DRect(0,0,100,100,false);
        }
    }
}