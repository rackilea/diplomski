public class Runner {

    public static void main(String[] args) {
        new Runner();
    }

    public Runner() throws HeadlessException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame obj = new JFrame();
                Panel j = new Panel();
                obj.setSize(640, 480);
                obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
                obj.setTitle("Rain");
                obj.add(j);
                obj.setLocationRelativeTo(null);
                obj.setResizable(false);
                obj.setVisible(true);
            }
        });
    }
}