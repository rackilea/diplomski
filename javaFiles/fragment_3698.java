public void randomAllTrack() {
    List<Track> randomTracks = new ArrayList<>(tracks);
    Collections.shuffle(randomTracks);
    for (Track track : randomTracks) {
        player.startPlaying(track.getFilename());
        System.out.printf("Now playing: %s - %s%n", track.getArtist(),
                track.getTitle());
    }
}