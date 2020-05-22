JFrame jf = new JFrame();
Test test = new Test();
test.setOpaque(false);
jf.getContentPane().setBackground(Color.YELLOW);
jf.add(test);
jf.setSize(1920, 1024);
jf.setVisible(true);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);