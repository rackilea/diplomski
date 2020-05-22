private static JFrame frame;
private static SplashFrame splash;

public static void main(String[] args) throws IOException {

    UIManager.put("swing.boldMetal", Boolean.FALSE);
    splash = new SplashFrame();

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(4500); //Extending time to show the splash screen
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            long startTime = System.currentTimeMillis();
            frame = new CFSMainFrame();
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Total time: " + ((float)totalTime/1000) + " seconds!");
            splash.closeFrame();

        }
    });
}