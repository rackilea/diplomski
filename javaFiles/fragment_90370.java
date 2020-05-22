JFrame window = new JFrame("Problems");
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout());
window.setContentPane(panel);

for(int i = 0; i < 8; i++) {
   panel.add(new Try());
}

window.pack();
window.setVisible(true);