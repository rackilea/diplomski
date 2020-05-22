Color oldColor = Oval.color;
Color newColor = randomColor();

// Calculate the difference between the old and new color
int rdiff = (oldColor.getRed() - newColor.getRed()) / 20;
int gdiff = (oldColor.getGreen() - newColor.getGreen()) / 20;
int bdiff = (oldColor.getBlue() - newColor.getBlue()) / 20;

for (int i = 0; i < 20; i++) {
    // Programmatically setup timers, because Thread.sleep() doesn't work here
    int delay = 10 * i;
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            // Get the current color and step one further
            int red = Oval.color.getRed() + rdiff;
            int green = Oval.color.getGreen() + gdiff;
            int blue = Oval.color.getBlue() + bdiff;

            oval.setColor(new Color(red, green, blue));
        }
    };
    new Timer(delay, taskPerformer).start();
}