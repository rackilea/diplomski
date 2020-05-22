List<Album> albums = parseJson("{...}");
for (Album album : albums) {
    // 'album' is a bad name here, it's storing records, not albums
    List<Record> records = album.getAlbum();
    for (Record record : records) {
        System.out.println(record.getSonName());
    }
}