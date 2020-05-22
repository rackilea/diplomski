// Numeric: integer and floats in various formats
case 'x':
case 'X':
case 'd':
case 'o':
case 'e':
case 'E':
case 'f':
case 'g':
case 'G':
case 'a':
case 'A':
    valid = type == Integer.TYPE
            || type == Float.TYPE;
    break;