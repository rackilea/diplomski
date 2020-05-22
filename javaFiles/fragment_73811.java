class EntryPointForApplication extends UiApplication {

    private static EntryPointForApplication theApp;

    public EntryPointForApplication() { 
        GUIApplication scr = new GUIApplication(); 
        pushScreen(scr);         
    } 

    public static void main(String[] args) { 

        if ( args != null && args.length > 0 && args[0].equals("background1") ){
            // Keep this instance around for rendering
            // Notification dialogs.
            BackgroundApplication backApp=new BackgroundApplication();
            backApp.setupBackgroundApplication();   
            backApp.enterEventDispatcher();
       } else {       
         if (theApp == null) {
             // Start a new app instance for GUI operations.     
             theApp = new EntryPointForApplication();
             theApp.enterEventDispatcher();         
         } 
       }        
    }   
}