EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        DrawablePane pane = new DrawablePane();
        pane.add(new RectangleDrawable(10, 10, 100, 150, Color.YELLOW, Color.GREEN));
        pane.add(new OvalDrawable(100, 20, 50, 50, Color.MAGENTA, Color.BLUE));

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
});