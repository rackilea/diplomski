for (Track track : album.getTracks()) {
    boolean downloaded = false;
    while (!downloaded) {
        try {
            songdown.downloadTrack(track, directorio, formataudio);
            downloaded = true;
        } catch (TimeoutException te) { /* delete partially downloaded song etc */ }
    }
}