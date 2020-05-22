public class Test {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                final JFrame jf = new JFrame();
                jf.setSize(800, 600);
                jf.setTitle("Test");
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.getContentPane().setLayout(new BorderLayout());
                final JPanel panel = new JPanel();
                panel.setBackground(Color.red);
                jf.getContentPane().add(panel, BorderLayout.CENTER);
                jf.setVisible(true);

                final JPanel box = new JPanel();
                box.setPreferredSize(new Dimension(100, 100));
                box.setBackground(Color.black);

                panel.add(box, BorderLayout.CENTER);
                box.setToolTipText("Inside");
                panel.setToolTipText("Outside");
            }
        });
    }
}