MainFrame mf;

SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        mf  = new MainFrame(Workers); //jFrame
    }   
});