public class ProxyActionListener extends JPanel {

    public static final String id = "id";
    private List<JRadioButton> buttons;

    public ProxyActionListener() {

        buttons = new ArrayList<>(25);
        ActionHandler actionHandler = new ActionHandler();

        for (int i = 1; i < 5; i++) {
            JRadioButton jrb = new JRadioButton(i + "", false);
            jrb.putClientProperty(id, i);
            this.add(jrb);
            jrb.addActionListener(actionHandler);
            buttons.add(jrb);

        }

    }

    public void addActionListener(ActionListener listener) {
        for (JRadioButton btn : buttons) {
            btn.addActionListener(listener);
        }
    }

    public void removeActionListener(ActionListener listener) {
        for (JRadioButton btn : buttons) {
            btn.removeActionListener(listener);
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

                ProxyActionListener pal = new ProxyActionListener();
                pal.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JRadioButton jrb = (JRadioButton) e.getSource();
                        Integer id = (Integer) jrb.getClientProperty(ProxyActionListener.id);
                        System.out.println("Proxy- id " + id);
                    }
                });

                JFrame frame = new JFrame("Radio buttons");
                frame.getContentPane().setLayout(new FlowLayout());
                frame.setSize(400, 100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(pal);
                frame.setVisible(true);
            }
        });
    }

    protected class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JRadioButton jrb = (JRadioButton) e.getSource();
            Integer id = (Integer) jrb.getClientProperty(ProxyActionListener.id);
            System.out.println("id " + id);

        }
    }
}