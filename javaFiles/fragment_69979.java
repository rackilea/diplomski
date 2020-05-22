JFrame frame = new JFrame("DesktopEsimerkki");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // this guy creates the menu
    DesktopEsimerkki desim = new DesktopEsimerkki();
    frame.setJMenuBar(desim.luoValikkoPalkki());

    // but this separate guy is used as the GUI
    DesktopEsimerkki newContentPane = new DesktopEsimerkki();
    newContentPane.setOpaque(true);
    frame.setContentPane(newContentPane);