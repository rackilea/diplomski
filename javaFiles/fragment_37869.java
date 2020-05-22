JFrame frame = new JFrame();
JFXPanel jfxPanel = new JFXPanel();
frame.add(jfxPanel);
frame.setVisible(true);
Platform.runLater(() -> {
    AnimatedChart animatedChart = new AnimatedChart();
    Scene scene = new Scene(animatedChart.getView());
    jfxPanel.setScene(scene);
    animatedChart.play();
});