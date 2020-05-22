//define a property to animate
float opacity;

//define timeline for animation
Timeline timeline = new Timeline(this);
timeline.addPropertyToInterpolate("opacity", 1.0f, 0.0f);
timeline.play();

//inside painting 
...
Graphics2D g2d = (Graphics2D) g.create();
g2d.setComposite(AlphaComposite.SrcOver.derive(this.opacity));
g2d.drawImage(img1...);

g2d.setComposite(AlphaComposite.SrcOver.derive(1.0 - this.opacity));
g2d.drawImage(img1...);

g2d.dispose();
...