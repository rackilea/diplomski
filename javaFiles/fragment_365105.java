public Timer(Ellipse ellipse, Glitchpanel glitch) {
    super(100, null);
    ellipse = ellipse;
    glitch = glitch;
    this.addActionListener(new MoveListener());
}