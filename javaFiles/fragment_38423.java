public String replace(CharSequence target, CharSequence replacement) {
    if (target == null) {
        throw new NullPointerException("target should not be null");
    }
    if (replacement == null) {
        throw new NullPointerException("replacement should not be null");
    }
    String ts = target.toString();
    int index = indexOf(ts, 0);

    if (index == -1)
        return this;

    String rs = replacement.toString();
    StringBuilder buffer = new StringBuilder(count);
    int tl = target.length();
    int tail = 0;
    do {
        buffer.append(value, offset + tail, index - tail);
        buffer.append(rs);
        tail = index + tl;
    } while ((index = indexOf(ts, tail)) != -1);
    //append trailing chars
    buffer.append(value, offset + tail, count - tail);

    return buffer.toString();
}