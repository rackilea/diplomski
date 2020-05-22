/**
 * Sets the custom component as popup component for the combo-box.
 *
 * @param combo combo-box to get new popup component.
 * @param comp new popup component.
 * @param widthIncr width increment for pop-up.
 * @param heightIncr height increment for pop-up.
 */
public static void setPopupComponent(JComboBox<?> combo, Component comp, int widthIncr, int heightIncr) {
    final ComboPopup popup = (ComboPopup) combo.getUI().getAccessibleChild(combo, 0);
    if (popup instanceof Container) {
        final Container c = (Container) popup;
        c.removeAll();
        c.setLayout(new GridLayout(1, 1));
        c.add(comp);
        final Dimension size = comp.getPreferredSize();
        size.width += widthIncr;
        size.height += heightIncr;
        c.setPreferredSize(size);
    }
}