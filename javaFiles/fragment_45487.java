Timeline clock = new Timeline(
    new KeyFrame(Duration.seconds(0), evt -> {
        LocalTime now = LocalTime.now();
        hour.set(String.format("%d", now.getHour()));            
        minute.set(String.format("%02d", now.getMinute()));            
        second.set(String.format("%d", now.getSecond()));            
    }),
    new KeyFrame(Duration.seconds(1))
);
clock.setCycleCount(Animation.INDEFINITE);
clock.play();