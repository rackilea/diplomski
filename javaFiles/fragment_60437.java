public class SimpleExample {

private MarvinImagePlugin tempPlugin;

public SimpleExample(){

    // 1. Load and set up plug-in.
    tempPlugin  = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.morphological.erosion");

    boolean[][] m = new boolean[][] {
    {true,true,true},
    {true,true,true},
    {true,true,true}
    };

    tempPlugin.setAttributes("matrix", m);

    // 2. Load image
    MarvinImage image = MarvinImageIO.loadImage("./res/erosion_in.png");
    MarvinImage resultImage = MarvinColorModelConverter.rgbToBinary(image, 127);

    // 3. Process and save image
    tempPlugin.process(resultImage.clone(), resultImage);
    resultImage = MarvinColorModelConverter.binaryToRgb(resultImage);
    resultImage.update();
    MarvinImageIO.saveImage(resultImage, "./res/erosion_out.png");
}

public static void main(String[] args) {
    new SimpleExample();
}

}