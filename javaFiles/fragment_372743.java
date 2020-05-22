JFrame frame = new JFrame("Test");
JPanel panel = new JPanel(new GridLayout(2, 2));
frame.setContentPane(panel);

frame.setVisible(true);
JLabel label1 = new JLabel();
panel.add(label1);
JLabel label2 = new JLabel();
panel.add(label2);
JLabel label3 = new JLabel();
panel.add(label3);
JLabel label4 = new JLabel();
panel.add(label4);

try {
    BufferedImage myPicture = ImageIO.read(new File("test.jpg"));

    label1.setIcon(new ImageIcon(myPicture));
    label2.setIcon(new ImageIcon(myPicture));
    label3.setIcon(new ImageIcon(myPicture));
    label4.setIcon(new ImageIcon(myPicture));
} catch (Exception e) {
    e.printStackTrace();
}

frame.pack();
frame.setMinimumSize(frame.getPreferredSize());