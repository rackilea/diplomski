public SearchByLyricsWords(SongCollection sc) {
    this.songs= sc.getAllSongs();
    insertions=0;
    totalReferences=0;
    averageReferences=0;
    buildSongMap();
}