for (     int i = 0; i < h; i++ ) {
        for ( int j = 0; j < w; j++ ) {

            Color c = new Color( inicial[i * w + j] );

            procesarBN[i][j] = (int) ( 0.2989 * c.getRed()
                                     + 0.5870 * c.getGreen()
                                     + 0.1140 * c.getBlue()
                                       );
        }
    }