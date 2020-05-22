JTextField textField1 = new JTextField(2);
BufferedImage myPicture1 = ImageIO.read(new File("C:\\Users\\tony\\Desktop\\JapanesePanNoodles.png"));
Image scaled1 = myPicture1.getScaledInstance(80,95,Image.SCALE_SMOOTH);
JLabel picLabel1 = new JLabel("Japanese Noodles",new ImageIcon(scaled1),JLabel.CENTER);
picLabel1.setHorizontalTextPosition(JLabel.CENTER);
picLabel1.setVerticalTextPosition(JLabel.BOTTOM);