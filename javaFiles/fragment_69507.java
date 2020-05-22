final int QUEUE_SIZE = 2;
    final BlockingQueue<MediaPlayer> playerQueue = new ArrayBlockingQueue<>(QUEUE_SIZE);
    final MediaView mediaView = new MediaView();


    Thread createPlayerThread = new Thread( () -> {
        final List<File> videoFiles = ...
        IntStream.iterate(0, index -> (index + 1) % videoFiles.size())
            .mapToObj(videoFiles::get)
            .map(file -> createPlayer(file, mediaView, playerQueue))
            .forEach(player -> {
                try {
                    playerQueue.put(player);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ;
                }
            });
    });
    createPlayerThread.setDaemon(true);
    createPlayerThread.start();

    // do layout, etc...

    try {
        mediaView.setMediaPlayer(playerQueue.take());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // ...

private MediaPlayer createPlayer(File file, MediaView mediaView, BlockingQueue<MediaPlayer> playerQueue) {
    URI uri = file.toURI();
    Media media = new Media(uri.toString());
    MediaPlayer player = new MediaPlayer(media);
    player.setAutoPlay(true);
    player.setOnEndOfMedia( () -> {
        Task<MediaPlayer> nextPlayerTask = new Task<MediaPlayer>() {
            @Override
            protected MediaPlayer call() throws Exception {
                return playerQueue.take();
            }
        };
        nextPlayerTask.setOnSucceeded(workerStateEvent -> 
            mediaView.setMediaPlayer(nextPlayerTask.getValue()));
    });
    return player ;
}