private void playPauseClicked() {
    Status currentStatus = player.getStatus();

    if(currentStatus == Status.PLAYING)
        player.pause();
    else if(currentStatus == Status.PAUSED || currentStatus == Status.STOPPED) {
        System.out.println("Player will start at: " + player.getCurrentTime());
        player.play();
    }
}

player.setOnPaused(() -> System.out.println("Paused at: " + player.getCurrentTime()));