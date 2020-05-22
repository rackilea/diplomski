frame2.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        frame2.dispose();
    }
});

OR

frame2.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);