BasicRobot robot = (BasicRobot) BasicRobot.robotWithCurrentAwtHierarchy()

new Thread(new Runnable() {
    @Override 
    public void run() {
        MainFrame.button("setup").click();
    } 
}).start();
DialogFixture setupViewDialog = WindowFinder.findDialog( "setup" ).using( robot );
new Thread(new Runnable() { 
    @Override
    public void run() {
        setupViewDialog.button("Save").click();
    } 
}).start();