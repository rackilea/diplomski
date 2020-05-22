static public Insets getScreenInsets(Window wnd) {
    Insets                              si;

    try {
        if(wnd==null) { si=Toolkit.getDefaultToolkit().getScreenInsets(new Frame().getGraphicsConfiguration()); }
        else          { si=wnd.getToolkit()           .getScreenInsets(wnd.getGraphicsConfiguration());         }
        } catch(NoSuchMethodError thr) { si=new Insets(0,0,0,0); }
    return si;
    }