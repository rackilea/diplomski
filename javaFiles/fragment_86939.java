public static void main(String[] args) throws IOException {

    String imgFormat = "PNG";

    Path2D path = new Path2D.Double();
    BasicStroke pathStroke = 
        new BasicStroke( 2 );


    // Create the path to be clipped:       
    int pathPoints[] = { 0, 10, 30, 10 };
    path.moveTo( pathPoints[ 0 ], pathPoints[1] );
    for( int i = 2; i < pathPoints.length; i+=2 ) {
        path.lineTo( pathPoints[ i ], pathPoints[ i+1 ] );
    }
    // Create the shape representing the clip area
    Polygon clipShape = new Polygon();
    int triPoints[] = { 10, 0, 20, 20, 20, 0 };
    for( int i = 0; i < triPoints.length; i+=2 ) {
        clipShape.addPoint( triPoints[i], triPoints[i+1] );
    }
    // Create the path with area using the stroke
    Shape clippedPath = pathStroke.createStrokedShape( path );

    // Apply a scale so the image is easier to see
    int scale = 10;
    AffineTransform at = AffineTransform.getScaleInstance( scale, scale );
    Shape sPath = at.createTransformedShape( path );
    Shape sClip = at.createTransformedShape( clipShape );

    // Create the Area shape that represents the path that is clipped by the clipShape
    Area clipArea = new Area( sClip );
    clipArea.intersect( new Area( at.createTransformedShape( clippedPath ) ) );


    int bbox = 10;
    Rectangle rect = sPath.getBounds();
    rect.add( sClip.getBounds() );
    // Expand the drawing area      
    rect.width += bbox;
    rect.height += bbox;
    rect.x -= bbox/2;
    rect.y -= bbox/2;
    BufferedImage img = new BufferedImage( rect.width, rect.height, BufferedImage.TYPE_INT_ARGB  );
    Graphics2D g2 = img.createGraphics();

    g2.setStroke( pathStroke );
    g2.setColor( Color.black );
    g2.draw( sPath );

    g2.setColor( Color.red );
    g2.draw( sClip );

    g2.setColor( Color.green );
    g2.draw( clipArea );

    g2.finalize();

    File img1 = new File( "/tmp/img1.png" );
    ImageIO.write( img, imgFormat, img1 );
}