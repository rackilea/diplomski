protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
    int tabCount = tabPane.getTabCount();

    Rectangle iconRect = new Rectangle(),
              textRect = new Rectangle();
    Rectangle clipRect = g.getClipBounds();

    for (int i = runCount - 1; i >= 0; i--) {
        int start = tabRuns[i];
        int next = tabRuns[(i == runCount - 1)? 0 : i + 1];
        int end = (next != 0? next - 1: tabCount - 1);
        for (int j = start; j <= end; j++) {
            if (j != selectedIndex && rects[j].intersects(clipRect)) {
                paintTab(g, tabPlacement, rects, j, iconRect, textRect);
            }
        }
    }

    if (selectedIndex >= 0 && rects[selectedIndex].intersects(clipRect)) {
        paintTab(g, tabPlacement, rects, selectedIndex, iconRect, textRect);
    }

}