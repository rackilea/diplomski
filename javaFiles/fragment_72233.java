public MainPanel(Model model) {
    actionPanel = new ActionPanel(model);
    controlsPanel = new ControlsPanel(model);
    colorPanel = new ColorPanel();

    setLayout(new GridLayout(2,1));
    add(controlsPanel);
    add(actionPanel);
    add(colorPanel);

}

 public void resetComponents() {
     controlsPanel.resetComponents();
     actionPanel.resetComponents();
 }