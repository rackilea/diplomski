final static Color labelBG = new Color(255,240,240);  
final static Color labelFG = new Color(3,25,180);
final static Font labelFont = new Font("Monospaced", Font.BOLD, 16);
private JLabel countLabel;

countLabel = makeLabel("Number of Entries:", 2);

private JLabel makeLabel(String text, int con) {
   JLabel label = new JLabel(text, con);
   label.setBackground(labelBG);
   label.setForeground(labelFG);
   label.setFont(labelFont);
   label.setOpaque(true);

return label;

}