public class TestPane extends JPanel implements Colorable {

    private JButton btn;
    private ColorChangerWorker changer;

    public TestPane() {
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        btn = new JButton("I am your button");
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (changer == null) {
                    changer = new ColorChangerWorker(TestPane.this);
                    changer.execute();
                }
            }
        });
    }

    @Override
    public void setColor(Color color) {
        if (EventQueue.isDispatchThread()) {
            btn.setBackground(color);
        } else {
            System.out.println("Not in the EDT");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    setColor(color);
                }
            });
        }
    }

}