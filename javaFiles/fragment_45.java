public static int findYear(MusicV3[] songs, int year) {
    int high = songs.length;
    int low = -1;
    int probe = -1;

    while (high - low > 1) {
        probe = (high + low) / 2;
        int probeSongYear = songs[probe].getYear();

        if (probeSongYear == year) {
            break;
        } else if (probeSongYear > year)
            high = probe;
        else
            low = probe;
    }

    if (probe >= 0 && songs[probe].getYear() == year) {
        while (songs[--probe].getYear() == year) {
        }
        return probe + 1;
    }

    return -1;
}