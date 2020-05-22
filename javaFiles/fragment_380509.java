// orientation, min, max, initial value
final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 2, 1);
slider.setSnapToTicks(true); // only allow 0, 1, 2 and not in between
slider.setPaintTicks(true); // paint ticks at tick spacing interval
slider.setMajorTickSpacing(1); // set interval to 1
slider.setPaintLabels(true); // show labels on ticks