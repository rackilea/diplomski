private JSlider slider1 = new JSlider();
  private JSlider slider2 = new JSlider();

  public SliderTestFrame()
  {
      setTitle("SliderTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      sliderPanel = new JPanel();
      sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

      // common listener for all sliders
      listener = new ChangeListener()
      {
          public void stateChanged(ChangeEvent event)
          {
              // update text field when the slider value changes
              textField.setText("" + (slider1.getValue() + slider2.getValue()));
        }
     };