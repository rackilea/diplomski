private static Clip clip = null;

public static void stop() {
    if (clip != null) {
        clip.stop();
        clip = null;
    }
}

public static void play(String toPlayName) {
    stop();
    File toPlay = new File(toPlayName);
    try {
        clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(toPlay));
        clip.start();
    } catch (Exception e) {
    }
}

public static void crowd() {
    play("crowd.wav");
}

public static void applause() {
    play("Applause.wav");
}

public static void check() {
    play("check.wav");
}