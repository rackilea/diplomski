static JButton makeButton(JPanel dis, String str, int x1, int y1, int x2, int y2, ActionListener a){
    JButton but = new JButton(str);
    but.setBounds(x1, y1, x2, y2);
    but.setContentAreaFilled(false);
    but.setForeground(Color.WHITE);
    but.setFont(new Font("Italics", Font.BOLD, 70));
    but.addActionListener(a);
    but.setFocusable(false);
    return but;
}