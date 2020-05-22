public class GrayScaleMask {

    public GrayScaleMask(){

        MarvinImage image = MarvinImageIO.loadImage("./res/grayscaleMask_input.png");
        MarvinImage mask = MarvinImageIO.loadImage("./res/grayscaleMask_mask.png");
        grayscaleMask(image.clone(), image, mask);
        MarvinImageIO.saveImage(image, "./res/grayscaleMask_output.png");
    }

    private void grayscaleMask(MarvinImage image, MarvinImage imageOut, MarvinImage mask){
        int r1,r2,g1,g2,b1,b2;
        double maskGray, factorMask, factorImage;
        for(int y=0; y<image.getHeight(); y++){
            for(int x=0; x<image.getWidth(); x++){
                r1 = image.getIntComponent0(x, y);
                g1 = image.getIntComponent1(x, y);
                b1 = image.getIntComponent2(x, y);
                r2 = mask.getIntComponent0(x, y);
                g2 = mask.getIntComponent1(x, y);
                b2 = mask.getIntComponent2(x, y);
                maskGray = (r2*0.21)+(g2*0.72)+(b2*0.07);
                factorMask = 1-(maskGray/255);
                factorImage = 1-factorMask;
                imageOut.setIntColor(x, y,  (int)(r1*factorImage+r2*factorMask),
                                            (int)(g1*factorImage+g2*factorMask),
                                            (int)(b1*factorImage+b2*factorMask));

            }
        }
    }

    public static void main(String[] args) {
        new GrayScaleMask(); System.exit(0);
    }
}