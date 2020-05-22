String search = artist.toLowerCase();
for (Song s : songs) {
    if (s.getArtist().toLowerCase().contains(search)) {
        System.out.println(s.toString());
    }
}