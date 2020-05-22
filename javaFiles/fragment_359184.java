if ( i < l &&
            ((i != l - 1) ||
            (in.charAt(i) != 'f' &&
             in.charAt(i) != 'F' &&
             in.charAt(i) != 'd' &&
             in.charAt(i) != 'D'))) {
            break parseNumber; // go throw exception
        }