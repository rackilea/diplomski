public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                ObserverPanel op = new ObserverPanel();
                op.setBorder(new CompoundBorder(new LineBorder(Color.RED), new EmptyBorder(10, 10, 10, 10)));
                GeneratorPane pp = new GeneratorPane(op);
                pp.setBorder(new CompoundBorder(new LineBorder(Color.GREEN), new EmptyBorder(10, 10, 10, 10)));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(2, 1));
                frame.add(pp);
                frame.add(op);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}