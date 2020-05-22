try {
    inputFile = null;
    inputImage = ImageIO.read(inputFile);
} catch(IOException e){
    e.printStackTrace();
    System.out.println("image file path is null");
}