GUI mygui = GUIBuilder.createNewGUI();

ButtonListener OK = new OKButtonListener();
ButtonListener Cancel = new CancelButtonListener();
DataListener dataReady = new dataReadyListener();

mygui.registerButtonListener(OK);
mygui.registerButtonListener(Cancel);
mygui.registerDataListener(dataReady);

mygui.show();