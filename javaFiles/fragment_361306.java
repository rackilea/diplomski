public static String convertByteArrayToHexString(byte[] b) {
    if (b != null) {
        StringBuilder s = new StringBuilder(2 * b.length);

        for (int i = 0; i < b.length; ++i) {
            final String t = Integer.toHexString(b[i]);
            final int l = t.length();
            if (l > 2) {
                s.append(t.substring(l - 2));
            } else {
                if (l == 1) {
                    s.append("0");
                }
                s.append(t);
            }
        }

        return s.toString();
    } else {
        return "";
    }
}