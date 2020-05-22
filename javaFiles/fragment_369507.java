board.setButton2Action( () -> {
        // On each click of the button, rotate to the next color in a sequence of colors numbered 0-7. 
        int c = currentCode.getColor( … ) ; // TODO: Add assertion tests to verify you get back a valid value as expected.
        c = ( c + 1 ) ;  // Increment the color.
        if( c == 8 ) {  // If past the limit…
            c = 0 ;     // …go back to first number.
        }
        currentCode.setColor( selectedCircle , c ) ;
        drawCode( X_START , Y_START + LINE_SPACING * ( 6 - currentTry ) , currentCode ) ;
    }
);