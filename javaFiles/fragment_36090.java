int leftX = element.getLocation().getX();
int rightX = leftX + element.getSize().getWidth();
int middleX = (rightX + leftX) / 2;
int upperY = element.getLocation().getY();
int lowerY = upperY+element.getSize().getHeight();
int middleY = (upperY + lowerY) / 2;