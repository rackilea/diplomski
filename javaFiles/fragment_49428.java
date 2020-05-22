// Reading file
String filename="test.jpeg";

java.awt.image.BufferedImage bi;
try {
    bi = javax.imageio.ImageIO.read(new java.io.File(filename));
} catch (java.io.IOException ioe) {
    ioe.printStackTrace();
    return;
}

// Storing pixels
String[][] data=new String[bi.getHeight()][bi.getWidth()];

for(int y=0; y<bi.getHeight(); y++) {
    for(int x=0; x<bi.getWidth(); x++) {
        java.awt.Color c=new java.awt.Color(bi.getRGB(x, y));
        data[y][x]=c.getRed()+" "+c.getGreen()+" "+c.getBlue()+" "+c.getAlpha();
    }
}

// Outputting result
for(int y=0; y<data.length; y++) {
    for(int x=0; x<data[y].length; x++) {
        System.out.println("The color (RGBA) of the pixel @("+x+","+y+") is "+data[y][x]);  
    }
}