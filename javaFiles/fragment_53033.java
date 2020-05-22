image = createBitmap( width, height )
for( int x = 0; x < width; x++ )
    for( int y = 0; y < height; y++ )
    {
         double maxScore = -Double.MAX_VALUE
         for( Point p : points.keySet() ) 
         {
             double score = points.get(p)/p.distance( x, y ) //Inverse distance times point weight
             minDist = Math.max( maxScore, score )
         }
         image.setPixelColour( x, y, getColorForDistance( 1/minDist * points.get(p) )
    }