public class Audio {
public static void crossfade(MediaPlayer mp1, MediaPlayer mp2) {
    final double currentVolume = mp1.getVolume();
    mp2.setVolume(0);
    mp2.play();
    Timeline crossfade = new Timeline(new KeyFrame(Duration.seconds(2), 
            new KeyValue(mp1.volumeProperty(), 0), 
            new KeyValue(mp2.volumeProperty(), currentVolume)));
    crossfade.setOnFinished(event -> mp1.stop());
    crossfade.play();
}
}