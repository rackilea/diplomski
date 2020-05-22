@Override
protected void layoutDynamicModifiers(DrawContext dc, AVList modifiers, OrderedSymbol osym)
{
    this.currentLines.clear();

    if (!this.isShowGraphicModifiers())
        return;

    // Direction of Movement indicator. Placed either at the center of the icon or at the bottom of the symbol
    // layout.
    Object o = this.getModifier(SymbologyConstants.DIRECTION_OF_MOVEMENT);
    if (o != null && o instanceof Angle)
    {
        // The length of the direction of movement line is equal to the height of the symbol frame. See
        // MIL-STD-2525C section 5.3.4.1.c, page 33.
        double length = this.iconRect.getHeight();
        Object d = this.getModifier(SymbologyConstants.SPEED_LEADER_SCALE);
        if (d != null && d instanceof Number)
            length *= ((Number) d).doubleValue();

        if (this.useGroundHeadingIndicator)
        {
            List<? extends Point2D> points = MilStd2525Util.computeGroundHeadingIndicatorPoints(dc, osym.placePoint,
                (Angle) o, length, this.iconRect.getHeight());
            this.addLine(dc, Offset.BOTTOM_CENTER, points, LAYOUT_RELATIVE, points.size() - 1, osym);
        }
        else
        {
            List<? extends Point2D> points = MilStd2525Util.computeCenterHeadingIndicatorPoints(dc,
                osym.placePoint, (Angle) o, length);
            this.addLine(dc, Offset.CENTER, points, null, 0, osym);
        }
    }
}