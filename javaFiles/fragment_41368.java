public void Reinit()
{
    System.err.println("Context Reinit()");

    this.ds = JAWT_GetDrawingSurface(canvas, awt.GetDrawingSurface());
    try
    {
        lock();
        try
        {
            JAWTDrawingSurfaceInfo dsi = JAWT_DrawingSurface_GetDrawingSurfaceInfo(ds, ds.GetDrawingSurfaceInfo());

            JAWTX11DrawingSurfaceInfo dsiWin = JAWTX11DrawingSurfaceInfo.create(dsi.platformInfo());

            this.display = dsiWin.display();
            this.drawable = dsiWin.drawable();

            eglDisplay = eglGetDisplay(display);

            surface = eglCreateWindowSurface(eglDisplay,fbConfigs.get(0),drawable,(int[])null);

            eglMakeCurrent(eglDisplay,surface,surface,context);

            GLES.setCapabilities(glesCaps);

            JAWT_DrawingSurface_FreeDrawingSurfaceInfo(dsi, ds.FreeDrawingSurfaceInfo());
        }
        finally
        {
            unlock();
            System.err.printf("Unlock \n");
        }

    }
    catch (Exception e)
    {
        System.err.println("JAWT Failed" + e.getMessage());
    }
}