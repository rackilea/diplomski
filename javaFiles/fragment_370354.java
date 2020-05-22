private void appendImage(Bitmap bmp)
{
    tv.setTransformationMethod(null);
    SpannableString ss = new SpannableString("  ");
    ss.setSpan(new ImageSpan(bmp, ImageSpan.ALIGN_BASELINE), 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    tv.append(ss);
}