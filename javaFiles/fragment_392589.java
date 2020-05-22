private void init()
{
    JFrame frame = new JFrame();
    ...
    disp = new Window(frame);

    DisplayMode[] dms = gdev.getDisplayModes();

    DisplayMode use_dm = null;

    if(gdev.isFullScreenSupported())
    {
        disp.setBackground(Color.CYAN);
        disp.setForeground(Color.WHITE);
        gdev.setFullScreenWindow(disp);
    }

    use_dm = getMatchMode(dms, def_dm);

    try 
    {
        disp = gdev.getFullScreenWindow();
        if(disp != null)
        {
            ...
            disp.setFocusable(true);
            disp.addKeyListener((KeyListener)screen_list);
            ...
        }   
    }
    catch(IllegalArgumentException ex) 
    { 
         ex.printStackTrace();
    }   
}