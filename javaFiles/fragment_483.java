public class DiamondShape extends Path2D.Double {

    public DiamondShape(int width, int height) {
        moveTo(width / 2, 0);
        lineTo(width, height / 2);
        lineTo(width / 2, height);
        lineTo(0, height / 2);
        closePath();
    }

}