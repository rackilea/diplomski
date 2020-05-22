BufferedImage rangerIm = ImageIO.read(new File("src/Images/Sprites/Ranger.png"));
JLabel ranger = new JLabel( new ImageIcon(rangerIm) );
ranger.setSize( ranger.getPreferredSize() );

BufferedImage backgroundIm = Bg = ImageIO.read(new File("src/Images/BG.png"));
JLabel background = new JLabel( new ImageIcon(rangerIm) );

background.add( ranger );
f.add(background, BorderLayout.CENTER);

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setResizable(false);
f.pack();
f.setVisible(true);