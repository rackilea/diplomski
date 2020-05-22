JSlider slider = new JSlider(0, 0, 9, 5);
JSpinner spinner = new JSpinner(new SpinnerNumberModel(5.0, 0.0, 9.0, 1.0));

slider.addChangeListener(e -> spinner.setValue(slider.getValue()));
spinner.addChangeListener(e -> slider.setValue(((Number) spinner.getValue()).intValue()));

JOptionPane.showMessageDialog(null, new Object[] { slider, spinner });
System.out.println(spinner.getValue().getClass());