/**
     * Draws every other tick label and renders text in gray instead of white.
     */
    class MySecondaryLabelRenderer extends MyLineLabelRenderer {


        @Override
        public void drawLabel(Canvas canvas, XYGraphWidget.LineLabelStyle style,
                Number val, float x, float y, boolean isOrigin) {
            if(val.doubleValue() % 2 == 0) {
                final Paint paint = style.getPaint();
                if(!isOrigin) {
                    paint.setColor(Color.GRAY);
                }
                super.drawLabel(canvas, style, val, x, y, isOrigin);
            }
        }
    }