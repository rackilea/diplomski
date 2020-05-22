public class MinimapGamePanel extends JPanel {
    ...
    private static Thread t;

    public MinimapGamePanel() {
        super();
        logger.addAppender(GUILog4JFileHelper.fileAppender);
        gamePanelImage = new BufferedImage(320, 320, BufferedImage.TYPE_INT_ARGB);
        //TODO:: change values above upon picking minimap size
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        t = new Thread(new RefreshMinimapThread());
    }

    public void paintComponent(Graphics g) {
        logger.trace("begin: REPAINTNG...");
        g2 = (Graphics2D)g;

        if (refreshMinimap){

            t.start();
            //RefreshMinimap();
            refreshMinimap = false;
        }
        g2.drawImage(gamePanelImage, 0, 0, null);

        g2.dispose();

        logger.trace("end: REPAINTNG...");
    }

    private class RefreshMinimapThread implements Runnable {
        @Override
        public void run() {
            RefreshMinimap();
        }
    }