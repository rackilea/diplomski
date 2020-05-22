public class Audio{
public static void crossfade(MediaPlayer mp1, MediaPlayer mp2)
{
    double currentVol = mp1.getVolume();
    mp2.setVolume(0);
    mp2.play();
    SequentialTransition crossfade = new SequentialTransition();
    for (int i=0; i<20 i++) {
        PauseTransition pause = new PauseTransition(Duration.millis(100));
        pause.setOnFinished(event -> {
               mp1.setVolume(mp1.getVolume()-currentVol/20);
               mp2.setVolume(mp2.getVolume()+currentVol/20);
        });
        crossfade.getChildren().add(pause);
    }
    crossfade.setOnFinished(event -> mp1.stop());
    crossfade.play();
}
}