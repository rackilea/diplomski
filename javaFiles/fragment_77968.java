/**
 * Simplified filter that should make everything uppercase
 * it's a demo and will probably not work
 *  - based on InputFilter.AllCaps
 */
public static class AllCaps implements InputFilter {
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {

        // create a buffer to store the edited character(s).
        char[] v = new char[end - start];

        // extract the characters between start and end into our buffer
        TextUtils.getChars(source, start, end, v, 0);

        // make the characters uppercase
        String s = new String(v).toUpperCase();

        // and return them
        return s;
    }
}