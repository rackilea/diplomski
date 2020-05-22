public class GradientSpiderWebPlot extends SpiderWebPlot {

    private Color startColor, endColor;
    private float alpha;

    public GradientSpiderWebPlot(CategoryDataset data, Color startColor, Color endColor, float alpha) {
        // TODO Auto-generated constructor stub
        super(data);
        this.startColor = startColor;
        this.endColor = endColor;
        this.alpha = alpha;
    }

    @Override
    protected void drawRadarPoly(Graphics2D g2,
                                 Rectangle2D plotArea,
                                 Point2D centre,
                                 PlotRenderingInfo info,
                                 int series, int catCount,
                                 double headH, double headW) {

        Polygon polygon = new Polygon();

        EntityCollection entities = null;
        if (info != null) {
            entities = info.getOwner().getEntityCollection();
        }

        // plot the data...
        for (int cat = 0; cat < catCount; cat++) {

            Number dataValue = getPlotValue(series, cat);

            if (dataValue != null) {
                double value = dataValue.doubleValue();

                if (value >= 0) { // draw the polygon series...

                    // Finds our starting angle from the centre for this axis

                    double angle = getStartAngle()
                        + (getDirection().getFactor() * cat * 360 / catCount);

                    // The following angle calc will ensure there isn't a top
                    // vertical axis - this may be useful if you don't want any
                    // given criteria to 'appear' move important than the
                    // others..
                    //  + (getDirection().getFactor()
                    //        * (cat + 0.5) * 360 / catCount);

                    // find the point at the appropriate distance end point
                    // along the axis/angle identified above and add it to the
                    // polygon

                    Point2D point = getWebPoint(plotArea, angle,
                            value / this.getMaxValue());
                    polygon.addPoint((int) point.getX(), (int) point.getY());

                    // put an elipse at the point being plotted..

                    Paint paint = getSeriesPaint(series);
                    Paint outlinePaint = getSeriesOutlinePaint(series);
                    Stroke outlineStroke = getSeriesOutlineStroke(series);

                    Ellipse2D head = new Ellipse2D.Double(point.getX()
                            - headW / 2, point.getY() - headH / 2, headW,
                            headH);
                    g2.setPaint(paint);
                    g2.fill(head);
                    g2.setStroke(outlineStroke);
                    g2.setPaint(outlinePaint);
                    g2.draw(head);

                    if (entities != null) {
                        int row = 0; int col = 0;
                        if (this.getDataExtractOrder() == TableOrder.BY_ROW) {
                            row = series;
                            col = cat;
                        }
                        else {
                            row = cat;
                            col = series;
                        }
                        String tip = null;
                        if (this.getToolTipGenerator() != null) {
                            tip = this.getToolTipGenerator().generateToolTip(
                                    this.getDataset(), row, col);
                        }

                        String url = null;
                        if (this.getURLGenerator() != null) {
                            url = this.getURLGenerator().generateURL(this.getDataset(),
                                   row, col);
                        }

                        Shape area = new Rectangle(
                                (int) (point.getX() - headW),
                                (int) (point.getY() - headH),
                                (int) (headW * 2), (int) (headH * 2));
                        CategoryItemEntity entity = new CategoryItemEntity(
                                area, tip, url, this.getDataset(),
                                this.getDataset().getRowKey(row),
                                this.getDataset().getColumnKey(col));
                        entities.add(entity);
                    }

                }
            }
        }
        // Plot the polygon

        // Lastly, fill the web polygon if this is required

        Rectangle2D rec = polygon.getBounds2D();

        //Paint paint = getSeriesPaint(series);
        // create linear vertical gradient based upon the bounds of the polygon.
        Paint paint = new GradientPaint(new Point2D.Double(rec.getCenterX(),rec.getMinY()), startColor,
                new Point2D.Double(rec.getCenterX(),rec.getMaxY()), endColor);

        g2.setPaint(paint);
        g2.setStroke(getSeriesOutlineStroke(series));
        g2.draw(polygon);


        if (this.isWebFilled()) {
            // made this the variable alpha instead of the fixed .1f
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    alpha));
            g2.fill(polygon);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    getForegroundAlpha()));
        }
    }
}