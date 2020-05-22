public class FooFrame extends JFrame {

    public FooFrame() {

        // your code, copy/pasted
        setBackground(Color.white);
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.BLACK);
        JButton b1 = new JButton("test");
        bottom.add(b1);
        add(bottom, BorderLayout.CENTER);

        // set size & pack
        Dimension size = new Dimension(400, 400);
        setPreferredSize(size);
        setMinimumSize(size);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FooFrame().setVisible(true);
            }
        });
    }
}