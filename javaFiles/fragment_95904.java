// We add binding to the RootPane 
JRootPane rootPane = frame.getRootPane();

//Specify the KeyStroke and give the action a name
KeyStroke KEY = KeyStroke.getKeyStroke("control S");
String actionName = "captureMouseLoc";

//map the keystroke to the actionName
rootPane.getInputMap().put(KEY, actionName);

//map the actionName to the action itself
rootPane.getActionMap().put(actionName, action);