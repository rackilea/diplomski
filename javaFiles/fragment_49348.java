if (!See.isUndecorated()) {
    See.setUndecorated(true);
}
if(!See.isVisible()){
    See.setVisible(true);
}
See.setAlwaysOnTop(rootPaneCheckingEnabled);
See.setExtendedState(MAXIMIZED_BOTH);