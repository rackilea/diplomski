public LineChartDemo1(String title) {
    super(title);
    JPanel chartPanel = createDemoPanel();
    chartPanel.setPreferredSize(new Dimension(500, 270));
    this.add(chartPanel, BorderLayout.CENTER);
    this.add(new JLabel("Mouse wheel!", JLabel.CENTER), BorderLayout.SOUTH);
}