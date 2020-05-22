for ( int row = 0; row < 4; row++ ) // 4 rows
{
  for ( int col = 0; col < 4; col++ ) // 4 columns
  {
    g2d.translate(row*size, col*size); // change the location of the object

     for (int i = 0; i < 28; i++)  // draw it
     {
       int intSize = (int) Math.round(size);

       g2d.setColor(i % 2 == 0 ? Color.white : Color.white);
       g2d.fillRect(-intSize / 2, -intSize / 2, intSize, intSize);
       g2d.setColor(i % 2 == 0 ? Color.black : Color.black);
       g2d.drawRect(-intSize / 2, -intSize / 2, intSize, intSize);

       size = size * factor;
       g2d.rotate(alpha);
    }
  }
}