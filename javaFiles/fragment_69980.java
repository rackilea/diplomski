JFrame frame = new JFrame("DesktopEsimerkki");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // use only one instance for **both**
    DesktopEsimerkki desim = new DesktopEsimerkki();
    frame.setJMenuBar(desim.luoValikkoPalkki());

    // DesktopEsimerkki newContentPane = new DesktopEsimerkki();
    // newContentPane.setOpaque(true);
    // frame.setContentPane(newContentPane);

    // *********** here ***********
    frame.setContentPane(desim);