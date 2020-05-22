public class SpiralPath extends Path2D.Double {

    public SpiralPath(int size) {
        int numIterations = 5;
        int arcGrowDelta = (size / numIterations) / 2;
        int arcWidth = 0;

        int centerX = size / 2;
        int centerY = size / 2;
        moveTo(centerX, centerY);

        for (int i = 0; i < numIterations; i++) {
            append(new Arc2D.Double(centerX - arcWidth, centerY - arcWidth, 2 * arcWidth, 2 * arcWidth, 180, 180, Arc2D.OPEN), true);
            arcWidth += arcGrowDelta;
            append(new Arc2D.Double(centerX - arcWidth, centerY - arcWidth, 2 * arcWidth - arcGrowDelta, 2 * arcWidth, 0, 180, Arc2D.OPEN), true);
        }
    }

}