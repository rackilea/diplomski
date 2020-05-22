File directory = new File(System.getProperty("user.dir") 
         + System.getProperty("file.separator")+ "Images";

for(File file: directory.listFiles()) {
     BufferedImage image = ImageIO.read(file);
}