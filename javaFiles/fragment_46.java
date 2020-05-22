System.out.println("Searching for the year: 2014");
    find = findYear(songs, 2014);
    if (find != -1) {
        System.out.println("We found songs made in the year 2014 in the song list: ");
        while (sortedSongs[find].getYear() == 2014) {
            System.out.println(sortedSongs[find++]);
        }
    }