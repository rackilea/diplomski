mainWindow.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
mainWindow.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        try {    
            File file = new File("DarkTheme.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            getProperties().store(fileOut, "Dark theme background colour");
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mainWindow.dispose();
        }
    }
});