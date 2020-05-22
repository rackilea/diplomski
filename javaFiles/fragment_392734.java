JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(300, 300);

final AtomicBoolean justEnabled = new AtomicBoolean(false);
final JButton button = new JButton("click");

button.addMouseListener(new MouseAdapter() {

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton b = (JButton) e.getSource();
        if (!b.isEnabled())
            if (justEnabled.get())
                justEnabled.set(false);
            else
                System.out.println("you cannot click me again");
    }

});

button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        b.setEnabled(false);
        justEnabled.set(true);
    }
});

JButton enabler = new JButton("enable");
enabler.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setEnabled(true);
    }
});

frame.setLayout(new FlowLayout());
frame.add(button);
frame.add(enabler);
frame.setVisible(true);