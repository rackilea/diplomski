JPanel imageContainer;
JPanel dateContainer = new JPanel();
JPanel signContainer = new JPanel();

imageContainer = new N_BackgroundImage(iconToImage(new RotatedIcon(new ImageIcon(scaledImage), RotatedIcon.Rotate.UP)), (int) picWidth, (int) picHeight, screenIndex);

imageContainer.setLayout(new BorderLayout());

dateContainer.setLayout(new BorderLayout());
dateContainer.setBorder(new EmptyBorder(0, 0, 15, 15));
dateContainer.setBackground(new Color(1f, 0f, 0f, .0f)); // Transparent background
dateContainer.setForeground(Color.ORANGE);          
dateContainer.add(dateAndName, BorderLayout.PAGE_END);

signContainer.setLayout(new BorderLayout());
signContainer.setBorder(new EmptyBorder(0, 15, 15, 0));
signContainer.setBackground(new Color(1f, 0f, 0f, .0f)); // Transparent background
signContainer.setForeground(Color.WHITE);
signContainer.add(sign, BorderLayout.PAGE_END);

// Adding the new Layer on too of the image
imageContainer.add(dateContainer, BorderLayout.LINE_END);
imageContainer.add(signContainer, BorderLayout.LINE_START);

// Adding the new Container to the JFrame
getContentPane().add(imageContainer);