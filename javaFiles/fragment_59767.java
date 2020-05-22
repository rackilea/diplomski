@Override
public void updateMeasureState(TextPaint p) {
    p.setTypeface(mTypeface);
    // Note: This flag is required for proper typeface rendering
    p.setFlags(p.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    p.setTextSize(25);//or what ever size you want
}

@Override
public void updateDrawState(TextPaint tp) {
    tp.setTypeface(mTypeface);
    // Note: This flag is required for proper typeface rendering
    tp.setFlags(tp.getFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    tp.setTextSize(25);//or what ever size you want
}