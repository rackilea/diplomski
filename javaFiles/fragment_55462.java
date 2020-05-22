#import java.awt.geom.*;

   /* Create an ellipse given foci and distance. 
     (x1,y1) and (x2,y2) are  foci. semimajor axis (the sum of distances
     that define the ellipse) is *dist*.
     See
     for meaning of vars
   */
    public Shape makeEllipse (
        float x1, float y1, float x2, float y2, float dist
    )
    {
        // Create foci points
        Point2D f1 = new Point2D.Float (x1, y1);
        Point2D f2 = new Point2D.Float (x2, y2);

        // Calculate ellipse characteristics
        double a = dist / 2.0;
        double c = f1.distance (f2) / 2.0;
        // If 'dist' is smaller than the distance between foci, 
        // the ellipse is invalid
        if (a < c)
           die ("Invalid semimajor axis length"); 
        double b = Math.sqrt (a * a - c * c);

        Point2D centre = 
            new Point2D.Float ((x1 + x2) / 2.0, (y1 + y2) / 2.0);

        // Create a transform to rotate and translate the ellipse
        double theta = Math.atan2 (y2 - y1, x2 - x1);
        AffineTransform trans = new AffineTransform();
        trans.translate (centre.getX(), centre.getY());
        trans.rotate(theta);

        // Create an ellipse with correct size but origin at centre 
        Ellipse2D tmpEllipse = new Ellipse2D.Double (-a, -b, 2 * a, 2 * b);

        // Translate and rotate it to where it should be
        Shape ellipse = trans.createTransformedShape (tmpEllipse);

        return ellipse;
    }