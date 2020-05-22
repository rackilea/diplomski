@Override
public boolean isPaintable() {
    return true;
}

/**
 * Draws the number and unit in the rectangular region of the screen given
 * to this PropertyEditor.
 * @param gfx
 * @param box
 */
@Override
public void paintValue(Graphics gfx, Rectangle box) {
    Color oldColor = gfx.getColor();
    gfx.setColor(isEditable() ? EDITABLE_COLOR : NON_EDITABLE_COLOR);
    // drawString takes x, y of lower left corner of string, whereas the box
    // x, y is at the top left corner of the string; need to add to translate
    // to where the string should be drawn
    gfx.drawString(getAsText() + " " + getViewUnit(), 
            box.x + LEFT_MARGIN_PIXELS, box.y + LINE_HEIGHT_PIXELS);
    gfx.setColor(oldColor);
}