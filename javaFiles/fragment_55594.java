// Read from same package 
ImageIO.read(getClass().getResourceAsStream("c.png"));

// Read from absolute path
ImageIO.read(new File("E:/SOFTWARE/TrainPIS/res/drawable/c.png"));

// Read from images folder parallel to src in your project
ImageIO.read(new File("images/c.jpg"));

// Read from src/images folder
ImageIO.read(getClass().getResource("/images/c.png"))

// Read from src/images folder
ImageIO.read(getClass().getResourceAsStream("/images/c.png"))