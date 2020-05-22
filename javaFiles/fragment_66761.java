boolean configured = Boolean.parseBoolean(this.prefs.getValues("myapp.configured", new String[] { "false" })[0]);

if (configured && PictureA.getParent() == null) {
    // PictureA is not visible, but it should be.
    viewContent.removeComponent(viewText);
    panel.addComponent(PictureA);
    viewContent.addComponent(panel);
}