int duration = mediaPlayer.getDuration();
String time = String.format("%02d min, %02d sec", 
    TimeUnit.MILLISECONDS.toMinutes(duration),
    TimeUnit.MILLISECONDS.toSeconds(duration) - 
    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
);