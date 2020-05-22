public int[] findSong(String title) {
    List<Integer> indexesList = new ArrayList<>();
    // Iterate over the elements of the list
    for (Song song : songs) {
        if (song.getTitle().equals(title)) indexesList.add(songs.indexOf(song));
    }
    // If we have no songs return empty array
    if (indexesList.size() == 0) return new int[0];
    // Convert list to int array
    int[] indexes = new int[indexesList.size()];
    for (int i = 0; i < indexes.length; i++) {
        Integer integer = indexesList.get(i);
        if (integer != null) indexes[i] = integer.intValue();
        else indexes[i] = -1;
    }
    return indexes;
}