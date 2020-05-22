context.addInstallerEventListener(new InstallerEventListener() {
    public void installerEvent(InstallerEvent event) {
        if (event.getType() == EventType.SHOW_SCREEN) {
            new Thread(new Runnable() {
                public void run() {
                    // Add your code here                    
                }
            }).start();
        }
    }    
});
return true;