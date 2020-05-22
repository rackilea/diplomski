Point mousePoint = e.getLocationOnScreen();
Point containerLocation = container.getLocationOnScreen();
Dimension componentSize = component.getSize();

int x = mousePoint.x - componentSize.width / 2 - containerLocation.x;
int y = mousePoint.y - componentSize.height / 2 - containerLocation.y;
component.setLocation(x, y);