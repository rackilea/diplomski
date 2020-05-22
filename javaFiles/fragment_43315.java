public static void main(String[] args) throws IOException {

    UIManager.put("swing.boldMetal", Boolean.FALSE);

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            splash = new SplashFrame();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    long startTime = System.currentTimeMillis();
                    frame = new CFSMainFrame();
                    long endTime = System.currentTimeMillis();
                    long totalTime = endTime - startTime;
                    System.out.println("Total time: " + ((float)totalTime/1000) + " seconds!");
                    splash.closeFrame();
                }
            });
        }
    });
}