Example<?> ex;
switch (ch) {
    case 1:
        ex = new Example<Integer>();
        break;
    case 2:
        ex = new Example<Float>();
        break;
    case 3:
        ex = new Example<String>();
        break;
    default:
        throw new IllegalArgumentException("Unknown type " + ch);
}