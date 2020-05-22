Queue<File> musicList = new LinkedList<File>();

try (Scanner musicListReader = new Scanner(new File("Music_PlayList.txt"))) {

    while (musicListReader.hasNext()) {
        musicList.add(new File(musicListReader.next()));
    }

} catch (Exception e) {
    e.printStackTrace();
}

playNextMusicFile(musicList);

// ...

private void playNextMusicFile(Queue<File> musicList) {
    if (musicList.isEmpty()) {
        return ;
    }

    Media media = new Media(musicList.remove().toURI().toString());
    MediaPlayer player = new MediaPlayer(media);
    player.setOnEndOfMedia(() -> {
        player.dispose();
        playNextMusicFile(musicList);
    });
    player.play();
}