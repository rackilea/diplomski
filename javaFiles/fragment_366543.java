public static void makeRoundCorner(int bgcolor,int radius,View v,int strokeWidth,int strokeColor)
{
    GradientDrawable gdDefault = new GradientDrawable();
    gdDefault.setColor(bgcolor);
    gdDefault.setCornerRadius(radius);
    gdDefault.setStroke(strokeWidth, strokeColor);
    v.setBackgroundDrawable(gdDefault);
}