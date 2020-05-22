private JButton createZoom() {
    final JButton zoomX = new JButton("Zoom X");
    zoomX.setActionCommand(ChartPanel.ZOOM_IN_DOMAIN_COMMAND);
    zoomX.addActionListener(chartPanel);
    return zoomX;
}