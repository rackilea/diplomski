private JButton createZoom() {
    final JButton zoomX = new JButton(new AbstractAction("Zoom X") {

        @Override
        public void actionPerformed(ActionEvent e) {
            chartPanel.zoomInDomain(0, 0);
        }
    });
    return zoomX;
}