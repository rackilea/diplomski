Action sharedAction = new AbstractAction("some text") {
    ....
} 
sharedAction.putValue(Action.SMALL_ICON, someIcon);
myToolBar.add(sharedAction);
myNormalButton.setAction(sharedAction);