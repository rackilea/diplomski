public static int getLayer(JComponent c) {
    Integer i;
    if((i = (Integer)c.getClientProperty(LAYER_PROPERTY)) != null)
        return i.intValue();
    return DEFAULT_LAYER.intValue();
}

public int getLayer(Component c) {
    Integer i;
    if(c instanceof JComponent)
        i = (Integer)((JComponent)c).getClientProperty(LAYER_PROPERTY);
    else
        i = (Integer)getComponentToLayer().get((Component)c);

    if(i == null)
        return DEFAULT_LAYER.intValue();
    return i.intValue();
}