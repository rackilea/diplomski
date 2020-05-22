package stackoverflow;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ComputeImageTransform
{
    public static AffineTransform computeTransform(
            Rectangle2D imageBounds, Point2D a2, Point2D b2) {
        double dx = b2.getX() - a2.getX();
        double dy = b2.getY() - a2.getY();

        // compute length of segment
        double length = Math.hypot(dx, dy);

        // compute scaling factor from image width to segment length
        double scaling = length / imageBounds.getWidth();
        // compute rotation angle
        double rotation = Math.atan2(dy, dx);

        // build the corresponding transform
        // NOTE: the order of the individual transformations are applied is the
        // reverse of the order in which the transform will apply them!
        AffineTransform transform = new AffineTransform();
        transform.translate(a2.getX(), a2.getY());
        transform.rotate(rotation);
        transform.scale(scaling, scaling);
        transform.translate(-imageBounds.getX(), -imageBounds.getY());

        return transform;
    }

    public static void main(String[] args) {
        // transform top edge of image within this axis-aligned rectangle...
        double imageX = 20;
        double imageY = 30;
        double imageWidth = 400;
        double imageHeight = 300;

        Rectangle2D imageBounds = new Rectangle2D.Double(
                imageX, imageY, imageWidth, imageHeight);

        // to the line segment a2-b2:
        Point2D a2 = new Point2D.Double(100, 30);
        Point2D b2 = new Point2D.Double(120, 200);

        System.out.println("Transform image bounds " + imageBounds);
        System.out.println("  to top edge " + a2 + ", " + b2 + ":");

        AffineTransform transform = computeTransform(imageBounds, a2, b2);

        // test
        Point2D corner = new Point2D.Double();
        corner.setLocation(imageX, imageY);
        System.out.println("top left:     " + transform.transform(corner, null));

        corner.setLocation(imageX + imageWidth, imageY);
        System.out.println("top right:    " + transform.transform(corner, null));

        corner.setLocation(imageX, imageY + imageHeight);
        System.out.println("bottom left:  " + transform.transform(corner, null));

        corner.setLocation(imageX + imageWidth, imageY + imageHeight);
        System.out.println("bottom right: " + transform.transform(corner, null));
    }
}