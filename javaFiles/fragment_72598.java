final JFrame frame = new JFrame();
frame.setSize(600, 400);
frame.getContentPane().setLayout(new GridLayout(3, 1, 20, 20));
final JPanel[] panels = new JPanel[3];
for (int i = 0; i < panels.length; i++) {
    panels[i] = new JPanel();
    panels[i].setOpaque(true);
    frame.getContentPane().add(panels[i]);
}
frame.setVisible(true);
ActionListener action = new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        Random gen = new Random();

        Color color = new Color(gen.nextInt(256), gen.nextInt(256),
                gen.nextInt(256));
        frame.getContentPane().setBackground(color);

        for (int i = 0; i < panels.length; i++) {
            color = new Color(gen.nextInt(256), gen.nextInt(256),
                    gen.nextInt(256));
            panels[i].setBackground(color);
        }
    }
};

Timer t = new Timer(100, action);
t.setRepeats(true);
t.start();