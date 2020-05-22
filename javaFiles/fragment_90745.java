public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
    if (!ignoreCase) {
        return regionMatches(toffset, other, ooffset, len);
    }
    // Note: toffset, ooffset, or len might be near -1>>>1.
    if ((ooffset < 0) || (toffset < 0)
            || (toffset > (long)length() - len)
            || (ooffset > (long)other.length() - len)) {
        return false;
    }
    byte tv[] = value;
    byte ov[] = other.value;
    if (coder() == other.coder()) {
        return isLatin1()
          ? StringLatin1.regionMatchesCI(tv, toffset, ov, ooffset, len)
          : StringUTF16.regionMatchesCI(tv, toffset, ov, ooffset, len);
    }
    return isLatin1()
          ? StringLatin1.regionMatchesCI_UTF16(tv, toffset, ov, ooffset, len)
          : StringUTF16.regionMatchesCI_Latin1(tv, toffset, ov, ooffset, len);
}