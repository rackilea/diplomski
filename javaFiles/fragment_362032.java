public static final void setAntiAliasing(Graphics g, boolean yesno)
{
    Object obj = yesno ? RenderingHints.VALUE_ANTIALIAS_ON
                 : RenderingHints.VALUE_ANTIALIAS_OFF;

    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, obj);
}