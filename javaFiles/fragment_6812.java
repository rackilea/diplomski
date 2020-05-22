try {                
    image = ImageIO.read(files[lop]);
} 
catch (IOException ex) {
    throw new RuntimeException(ex);
}