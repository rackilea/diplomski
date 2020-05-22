public int findSong(String title) {
    int index = -1;
    // Iterate over the elements of the list
    for (Song song : songs) {
        if (song.getTitle().equals(title)) index = songs.indexOf(song);
    }
    // If you didn't know here we have if / else
    // if index == -1 print song not found else print the index
    System.out.println(index == -1 ? "Song not found: " + title : "Sound found at index " + index);
    // If song isn't found index is -1
    return index;
}