JTextField name = new JTextField(20);
name.setOpaque(false);
JTextField pass = new JTextField(20);
pass.setOpaque(false);
pass.setForeground(Color.WHITE);
// being lazy: use SwingX 
JXPanel panel = new JXPanel();
BufferedImage back = XTestUtils.loadDefaultImage("moon.jpg");
panel.setBackgroundPainter(new ImagePainter(back));
panel.add(name);
panel.add(pass);