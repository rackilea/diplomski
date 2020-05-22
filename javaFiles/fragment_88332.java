BufferedImage img = null;
try {
    img = ImageIO.read(new File("strawberry.jpg"));
} catch (IOException e) {
//it isn't the code here
}catch(OutOfMemoryError err){
// your code will be here :)
}