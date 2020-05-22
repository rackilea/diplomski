Eyes eyes = new Eyes();
eyes.setPreferredSize(new Dimension(600, 400));

JPanel content = new JPanel();
content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
frame.setContentPane(content);
content.add(players);
content.add(eyes);