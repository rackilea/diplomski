import static marvin.MarvinPluginCollection.*;

public class SegmentDiagram {

    public SegmentDiagram(){
        MarvinImage originalImage = MarvinImageIO.loadImage("./res/diagram.png");
        MarvinImage image = originalImage.clone();
        MarvinImage binImage = MarvinColorModelConverter.rgbToBinary(image, 250);
        morphologicalErosion(binImage.clone(), binImage, MarvinMath.getTrueMatrix(5, 5));
        image = MarvinColorModelConverter.binaryToRgb(binImage);
        MarvinSegment[] segments = floodfillSegmentation(image);

        for(int i=1; i<segments.length; i++){
            MarvinSegment seg = segments[i];
            originalImage.drawRect(seg.x1, seg.y1, seg.width, seg.height, Color.red);
            originalImage.drawRect(seg.x1+1, seg.y1+1, seg.width, seg.height, Color.red);
        }
        MarvinImageIO.saveImage(originalImage, "./res/diagram_segmented.png");
    }

    public static void main(String[] args) {
        new SegmentDiagram();
    }
}