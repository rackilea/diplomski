public Timer(Ellipse ellipse, Glitchpanel glitch) {
    super(100, null);
    this.ellipse = ellipse;
    this.glitch = glitch;
    this.addActionListener(new MoveListener());
}