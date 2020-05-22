// Actually should be "unsigned long", but Java.
long _temp = this.next_char();
switch _temp {
    case 35:
        // First branch...
        break;

    case 46:
        // Second branch...
        break;

    case 42:
        // Third branch...
        break;

    default:
        long c = _temp;
        if valid_identifier_char(c) {
            // Fourth branch...
        } else {
            // Final branch...
        }
        break;
}