frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        mediaPlayerComponent.getMediaPlayer().stop(); // Very important!
        frame.dispose();
    }
});