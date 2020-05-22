Display.getDefault().syncExec(new Runnable() { // <- try changing it to asyncExec
    public void run()
    {
        synchronized (gui)                     // <-- try removing this
        {
            AlertFlash alrt1 = new AlertFlash(gui);
            Thread flashing = new Thread(alrt1);
            flashing.start();
        }
    }
});