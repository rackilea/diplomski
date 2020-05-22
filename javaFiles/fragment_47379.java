for (;;) {
    ParsePosition pos = new ParsePosition(0);
    nf.parse(number, pos);
    if (pos.getErrorIndex() != -1) { // In fact for the exception catch.
        break;
    }
    int i = pos.getIndex();
    if (i == number.length()) { // Did all.
        break;
    }
    number = number.substring(0, i) + number.substring(i + 1);
}