boolean isInAnApplet(Component c)
{
    Component p = c.getParent();
    if (p != null) {
         return isInAnApplet(p);
    } else {
         return (c instanceof Applet);
    }
}