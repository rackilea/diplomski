refresh() {
    new Runnable(){
        clearData();
        SwingUtilities.invokeLater(new Runnable() {
            repaint();
        });
    }.run();
}