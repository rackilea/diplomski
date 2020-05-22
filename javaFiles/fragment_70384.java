switch (inps.charAt(i)) {
    case '1':
        values.add(HI);
        break;
    case '0':
        values.add(LO);
        break;
    case 'x':
    case 'X':
        values.add(X);
        break;
    case ' ':
    case '\t':
        break;
    default:
        throw ...;
}