private String getPrintableString(String string, PDFont font) {

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < string.length(); i++) {

        int codePoint = string.codePointAt(i);

        if (codePoint == 0x000A) {
            sb.appendCodePoint(codePoint);
            continue;
        }

        String fontName = font.getName();
        int cpKey = fontName.hashCode();
        cpKey = 31 * cpKey + codePoint;

        if (codePointAvailCache.get(cpKey) == null) {

            try {
                font.encode(string.substring(i, i + 1));
                codePointAvailCache.put(cpKey, true);
            } catch (Exception e) {
                codePointAvailCache.put(cpKey, false);
            }
        }

        if (!codePointAvailCache.get(cpKey)) {

            // Need to make sure our font has a replacement character
            try {
                codePoint = 0xFFFD;
                font.encode(new String(new int[] { codePoint }, 0, 1));
            } catch (Exception e) {
                codePoint = 0x003F;
            }
        }

        sb.appendCodePoint(codePoint);
    }

    return sb.toString();
}