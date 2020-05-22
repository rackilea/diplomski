BufferedImage result = new BufferedImage(img.getWidth(), img.getHeight(), img.getType()) ;
final int H = img.getHeight() - 1 ;
final int W = img.getWidth() - 1 ;

for (int c=0 ; c < img.getRaster().getNumBands() ; c++) // for all the channels/bands
    for (int x=1 ; x < W ; x++) // For all the image
        for (int y=1; y < H ; y++)
            {
            int newPixel = 0 ;
            for (int i=-1 ; i <= 1 ; i++) // For the neighborhood
                for (int j=-1 ; j <= 1 ; j++)
                    newPixel += img.getRaster().getSample(x+i, y+j, c) ;
            newPixel = (int)(newPixel/9.0 + 0.5) ;
            result.getRaster().setSample(x, y, c, newPixel) ;
            }