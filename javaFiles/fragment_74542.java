public class StatefulUtil {
    public static CharSequence encode(String value) {
        return separate(escape(value), Stateful.SEGMENT_SEP, 4);
    }

    public static String decode(String value) {
        return join(value.split("\\" + Stateful.SEGMENT_SEP), "").toString();
    }

    private static String escape(String value) {
        return value.replace(Stateful.DATA_SEP, "\\" + Stateful.DATA_SEP);
    }

    public static CharSequence format(int value) {
        return String.format("%04d", value);
    }

    public static CharSequence separate(String value, String separator, int offset) {
        StringBuffer buff = new StringBuffer(value);
        int n = buff.length() / offset;

        for (int i = 0; i < n; i++) {
            int index = i + ((i + 1) * offset);
            buff.insert(index, separator);
        }

        return buff;
    }

    public static CharSequence join(String[] arr, String separator) {
        StringBuffer buff = new StringBuffer();

        if (arr != null) {
            if (arr.length > 0) {
                buff.append(arr[0]);
            }

            for (int i = 1; i < arr.length; i++) {
                buff.append(separator).append(arr[i]);
            }
        }

        return buff;
    }

    // Regular expression: /^#|[^\\\\]#/ - Match beginning '#' and each non-escaped '#"
    public static String[] parse(String data) {
        return data.split("^" + Stateful.DATA_SEP + "|[^\\\\]" + Stateful.DATA_SEP);
    }
}