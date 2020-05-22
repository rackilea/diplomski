public Home() {
    initGUI();
    this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowOpened(WindowEvent e) {
            PlaySound.sound = new File("../Ajax/src/sound/Sound.wav");
            soundThread = new Thread(PlaySound.play).start();
        }
        //If you want the sound to stop you can just add another override, but you need to keep track of the sound thread
        @Override
        public void windowClosing(WindowEvent e) {
            soundThread.interrupt();
        }
    });
}