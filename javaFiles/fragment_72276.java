@Override
public CharSequence filter(CharSequence source, int start, int end,
        Spanned dest, int dstart, int dend) {
    if ( end == 0 && ind > 0 && dest.length() == 0 ) {
        pin[ind - 1].requestFocus();
    }
    return null;
}