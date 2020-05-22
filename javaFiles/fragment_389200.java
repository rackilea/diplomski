public static JPanel createDemoPanel() {
    JPanel panel = new JPanel();
    JFreeChart chart = createChart(createDataset());
    panel.add(new ChartPanel(chart));
    panel.add(createLegendPanel((PiePlot) chart.getPlot()));
    return panel;
}

private static JPanel createLegendPanel(PiePlot plot) {
    JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
    Iterator iterator = plot.getLegendItems().iterator();
    while (iterator.hasNext()) {
        LegendItem item = (LegendItem) iterator.next();
        JLabel label = new JLabel(item.getLabel());
        label.setIcon(new ColorIcon(8, item.getFillPaint()));
        panel.add(label);
    }
    return panel;
}