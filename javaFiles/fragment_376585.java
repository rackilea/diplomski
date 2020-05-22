boolean[][] pixBool;
BufferedImage img;

for(int a = 0; a < pixBool.length;a++){
    for(int b = 0; b < pixBool[0].length;b++){
        boolean pix = pixBool[a][b];
        if(pix){
            img.setRGB(a,b,0xff000000);  
        }
    }
}