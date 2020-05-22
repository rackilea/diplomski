public class SimpleSim extends JFrame {

    private static SimpleSim instance = null;

    public static SimpleSim getInstance() {
        if (instance == null) {
            instance = new SimpleSim();
        }

        return instance;
    }

    private SimpleSim() {
    }

    public void initialize() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);
        setLayout(new BorderLayout());

        update();

    }

    public void update() {
        System.out.println("NEXT: " + Thread.currentThread().getName());
        Random rand = new Random();

        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        SimplePanel simplePanel = new SimplePanel(new Color(r, g, b));
        JPanel contentPane = (JPanel) this.getContentPane();

        getContentPane().removeAll();
        add(simplePanel);

        revalidate();
    }

    public class SimplePanel extends JPanel {

        public SimplePanel(Color c) {

            setFocusable(true);
            setLayout(null);
            setBackground(c);
            setVisible(true);
            requestFocusInWindow();
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "A");
            am.put("A", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("a");
                    System.out.println("KEY: " + Thread.currentThread().getName());
                    SimpleSim.getInstance().update();
                }
            });

        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                SimpleSim.getInstance().initialize();
            }
        });
    }
}