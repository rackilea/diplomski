JFrame frame = new JFrame ("HelloWorldSwing");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel label = new JLabel("Hello world");
Container contentPane = frame.getContentPane();
contentPane.add(label);