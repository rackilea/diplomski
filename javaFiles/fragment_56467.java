private void paintText ( )
{
    if ( getText ( ) != null )
    {
        Point point = gc.stringExtent ( getText ( ) );

        if ( isHorizontalSlide )
        {
            if ( getMode ( ) == LEFT_MODE )
            {
                if ( pX + point.x + 1 >= rectangle.x )
                    pX = rectangle.width;
                gc.drawText ( getText ( ) , pX -- , pY );
            }
            else if ( getMode ( ) == RIGHT_MODE )
            {
                if ( pX >= rectangle.width )
                    pX = rectangle.x - point.x + 1;
                gc.drawText ( getText ( ) , pX ++ , pY );
                Color color = gc.getForeground ( );
                gc.setForeground ( getBackground ( ) );
                gc.drawLine ( pX - 1 , pY , pX - 1 , point.y );
                gc.setForeground ( color );
            }
            else
            {
                if ( pX + point.x + 1 >= rectangle.x )
                    pX = rectangle.width;
                gc.drawText ( getText ( ) , pX -- , pY );
            }

        }
        else if ( isVerticalSlide )
        {

            if ( getMode ( ) == UP_MODE )
            {
                if ( pY + point.y + 1 >= rectangle.y )
                    pY = rectangle.height;
                gc.drawText ( getText ( ) , pX , pY -- );
            }
            else if ( getMode ( ) == DOWN_MODE )
            {
                if ( pY >= rectangle.height )
                    pY = rectangle.y - point.y + 1;
                gc.drawText ( getText ( ) , pX , pY ++ );
            }
            else
            {
                if ( pY + point.y + 1 >= rectangle.y )
                    pY = rectangle.height;
                gc.drawText ( getText ( ) , pX , pY -- );
            }
        }
    }
    else
        throw new NullPointerException ( "The text cannot be null!" );
}