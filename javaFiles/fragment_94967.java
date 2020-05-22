JPanel colorSliderPanel = new JPanel(new GridBagLayout());

redSlider = new JSlider();
greenSlider = new JSlider();
blueSlider = new JSlider();

redField = new JTextField(4);
greenField = new JTextField(4);
blueField = new JTextField(4);

redField.setEditable(false);
greenField.setEditable(false);
blueField.setEditable(false);

JLabel redLabel = new JLabel("Red");
JLabel greenLabel = new JLabel("Green");
JLabel blueLabel = new JLabel("Blue");

addTo(colorSliderPanel, redLabel, redSlider, redField, 0);
addTo(colorSliderPanel, greenLabel, greenSlider, greenField, 1);
addTo(colorSliderPanel, blueLabel, blueSlider, blueField, 2);