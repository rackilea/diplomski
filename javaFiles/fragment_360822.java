public static ControlManager getControlManager() {

    if(controlManager == null) {
        controlManager = new ControlManager();
        return controlManager;
    }