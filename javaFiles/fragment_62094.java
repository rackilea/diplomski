@Override
    public void customize(final JFreeChart chart, final JRChart jasperChart) {

        final Plot plot = chart.getPlot();

        if (plot instanceof CategoryPlot) {
            final CategoryPlot cPlot = (CategoryPlot) plot;
            cPlot.getRangeAxis().setMinorTickCount(2);
            cPlot.getRangeAxis().setMinorTickMarksVisible(true);
        } else if (plot instanceof XYPlot) {
            final XYPlot xyPlot = (XYPlot) plot;
            xyPlot.setRangeMinorGridlinesVisible(true);
            xyPlot.getRangeAxis().setMinorTickCount(2);
            xyPlot.getRangeAxis().setMinorTickMarksVisible(true);

        }

    }