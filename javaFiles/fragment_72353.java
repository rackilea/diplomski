java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
         MainFrame mainfr = new MainFrame();
         mainfr.InititalMonitorsDetection();
         mainfr.DetectMonitors();
    }
});