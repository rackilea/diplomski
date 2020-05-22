import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.beans.Transient;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LatLongDemo extends JPanel {

    private double[][] coords;
    private double[][] coordsScaled;
    private final int maxLatitudeInPixels = 1200;
    private final int maxLongitudeInPixels = 700;
    private boolean scaled;

    public LatLongDemo() {
        Random rnd = new Random();
    double x = -29.8150081639178;
    double y = -55.74497604370117;
    coords = new double[][] {
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() },
            { x + rnd.nextDouble(), y + rnd.nextDouble() } };
        scaleCoords();
    }

    private void scaleCoords() {
        coordsScaled = new double[coords.length][2];
        double maxDistance = Double.MIN_VALUE;
        int indexOfLargestDistance = 0;

        for (int i = 0; i < coords.length; i++) {
            double latitude = Math.abs(coords[i][0]);
            double longitude = Math.abs(coords[i][1]);
            double distanceSquared = latitude * latitude + longitude
                    * longitude;

            if (distanceSquared > maxDistance) {
                maxDistance = distanceSquared;
                indexOfLargestDistance = i;
            }
        }

        double displaceLatitude = -coords[indexOfLargestDistance][0];
        double displaceLongitude = -coords[indexOfLargestDistance][1];
        double maxLatitude = Double.MIN_VALUE, maxLongitude = Double.MIN_VALUE;
        int indexOfMaxLatitude = 0, indexOfMaxLongitude = 0;

        for (int i = 0; i < coordsScaled.length; i++) {
            double latitude = coords[i][0] + displaceLatitude;
            double longitude = coords[i][1] + displaceLongitude;
            coordsScaled[i][0] = latitude;
            coordsScaled[i][1] = longitude;

            if (latitude > maxLatitude)
                maxLatitude = latitude;
            if (longitude > maxLongitude)
                maxLongitude = longitude;
        }

        double latitudeScale = maxLatitudeInPixels / maxLatitude;
        double longitudeScale = maxLongitudeInPixels / maxLongitude;

        for (int i = 0; i < coordsScaled.length; i++) {
            coordsScaled[i][0] = coordsScaled[i][0] * latitudeScale;
            coordsScaled[i][1] = coordsScaled[i][1] * longitudeScale;
        }
        scaled = true;
    }

    @Override
    @Transient
    public Color getBackground() {
        return Color.black;
    }

    @Override
    @Transient
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!scaled)
            return;

        Graphics2D g2d = (Graphics2D) g.create();
        FontMetrics fm = g2d.getFontMetrics();

        for (int i = 0; i < coordsScaled.length; i++) {
            double originalLatitude = coords[i][0];
            double originalLongitude = coords[i][1];
            double newLatitude = coordsScaled[i][0];
            double newLongitude = coordsScaled[i][1];

            Ellipse2D.Double point = new Ellipse2D.Double(newLatitude,
                    newLongitude, 5, 5);
            String original = "Original: " + originalLatitude + ","
                    + originalLongitude;
            String scaled = "Scaled: " + newLatitude + "," + newLongitude;

            float originalStringX = (float) (newLatitude - fm
                    .stringWidth(original));
            float originalStringY = (float) (newLongitude - fm.getHeight());
            float scaledStringX = (float) (newLatitude - fm.stringWidth(scaled));
            float scaledStringY = (float) (newLongitude + fm.getHeight());

            g2d.setColor(Color.white);
            g2d.drawString(original, originalStringX, originalStringY);
            g2d.drawString(scaled, scaledStringX, scaledStringY);
            g2d.setColor(Color.green);
            g2d.fill(point);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        LatLongDemo latLongDemo = new LatLongDemo();
        frame.getContentPane().add(latLongDemo);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}