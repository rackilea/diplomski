/**
     * Divides the given string into substrings each consisting of the provided
     * length(s).
     * 
     * @param string
     *            the string to split.
     * @param defaultLength
     *            the default length used for any extra substrings. If set to
     *            <code>0</code>, the last substring will start at the sum of
     *            <code>lengths</code> and end at the end of <code>string</code>.
     * @param lengths
     *            the lengths of each substring in order. If any substring is not
     *            provided a length, it will use <code>defaultLength</code>.
     * @return the array of strings computed by splitting this string into the given
     *         substring lengths.
     */
    public static String[] divideString(String string, int defaultLength, int... lengths) {
        java.util.ArrayList<String> parts = new java.util.ArrayList<String>();

        if (lengths.length == 0) {
            parts.add(string.substring(0, defaultLength));
            string = string.substring(defaultLength);
            while (string.length() > 0) {
                if (string.length() < defaultLength) {
                    parts.add(string);
                    break;
                }
                parts.add(string.substring(0, defaultLength));
                string = string.substring(defaultLength);
            }
        } else {
            for (int i = 0, temp; i < lengths.length; i++) {
                temp = lengths[i];
                if (string.length() < temp) {
                    parts.add(string);
                    break;
                }
                parts.add(string.substring(0, temp));
                string = string.substring(temp);
            }
            while (string.length() > 0) {
                if (string.length() < defaultLength || defaultLength <= 0) {
                    parts.add(string);
                    break;
                }
                parts.add(string.substring(0, defaultLength));
                string = string.substring(defaultLength);
            }
        }

        return parts.toArray(new String[parts.size()]);
    }