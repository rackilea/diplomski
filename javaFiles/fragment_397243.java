public static void setToolTipRecursively(JComponent c, String text) {

    c.setToolTipText(text);

    for (Component cc : c.getComponents())
        if (cc instanceof JComponent)
            setToolTipRecursively((JComponent) cc, text);
}