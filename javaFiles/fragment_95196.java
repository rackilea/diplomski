SwingUtils.invokeLater(new Runnable() {
    @Override
    public void run() {
        JFrame application = new JFrame();
        PanelFurniture panel = new PanelFurniture();
        application.add(panel);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(600,450);
        application.setLocationByPlatform(true);
        application.setVisible(true);
    }
});