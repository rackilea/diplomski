protected void paint(SynthContext context, Graphics g) {
    int selectedIndex = tabPane.getSelectedIndex();
    int tabPlacement = tabPane.getTabPlacement();

    ensureCurrentLayout();

// Paint tab area
// If scrollable tabs are enabled, the tab area will be
// painted by the scrollable tab panel instead.
//
if (!scrollableTabLayoutEnabled()) { // WRAP_TAB_LAYOUT

        [...]

        // Here is code calculating the content border

        [...]

    }

    // Paint content border
    paintContentBorder(tabContentContext, g, tabPlacement, selectedIndex);
}