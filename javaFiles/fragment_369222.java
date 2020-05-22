JFrame f = new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setBackground(new Color(0f, 0f, 0f, 0.1f));
f.setUndecorated(true);
f.add(new JLabel("<html>Testing<br>1, 2, 3</html>"));
f.pack();
f.setLocationRelativeTo(null);
f.setVisible(true);