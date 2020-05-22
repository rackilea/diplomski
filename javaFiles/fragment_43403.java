public class ArrowHead extends Path2D.Double {

    public ArrowHead() {
        int size = 10;
        moveTo(0, size);
        lineTo(size / 2, 0);
        lineTo(size, size);
    }

}