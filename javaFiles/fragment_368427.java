Rectangle screenBounds = MouseInfo.getPointerInfo().getDevice().getDefaultConfiguration().getBounds();

int x = (int) screenBounds.getCenterX() - (jDialog.getWidth() / 2);
int y = (int) screenBounds.getCenterY() - (jDialog.getHeight() / 2);

jDialog.setLocation(x, y);
jDialog.setVisible(true);