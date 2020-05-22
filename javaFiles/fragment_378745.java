....
WindowsSystemUtility.disableWindowsFunctionality(true);

shell = new Shell(getParent(), getStyle());

createMenu();

shell.layout();
shell.pack();   

Rectangle screenBounds = getParent().getMonitor().getBounds();
int monitorWidth = screenBounds.width;
int monitorHeight = screenBounds.height;
//System.out.println(monitorWidth + ", " + monitorHeight);

int dialogWidth = monitorWidth;
int dialogHeight = 0;   //height 0 - > shell has no height. only menu is shown
Rectangle shellBounds = shell.computeTrim(0, 0, dialogWidth, dialogHeight);
shell.setSize(shellBounds.width, shellBounds.height);

//place the dialog
int x = 0;
int y = 0;  //position north
//int y = monitorHeight - dialogHeight; //position south
shell.setLocation(x, y);

shell.open();
....