JSlider speed = new JSlider(0, 80); speed.setValue(0);
setting speedSett = new setting("speed", speed);
if (speeSett.getMain() instanceof JSlider) {
  JSlider slider = (JSlider) speedSett.getMain(); // Recommend to access from getter instead of direct access
  slider.getValue();
}