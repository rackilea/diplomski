BufferedImage bImage3 = new BufferedImage(bImage.getWidth(), bImage.getHeight(), bImage.getType());
for(int i = 0; i<bImage.getWidth(); i++){
    for(int j = 0; j<bImage.getHeight(); j++){
        bImage3.setRGB(i, j, Math.abs(bImage2.getRGB(i,j) - bImage.getRGB(i,j)));
    }
}