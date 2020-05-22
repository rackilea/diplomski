String sql = "INSERT INTO MyAlbums VALUES (?, ?, ?, ?, ?)";
PreparedStatement pstmt = connection.prepareStatement(sql);
if(album instanceof CDAlbum) {
    pstmt.setString(1, "CD");
    CDAlbum cdAlbum = (CDAlbum)album;
    pstmt.setString(4, cdAlbum.getArtist());
    pstmt.setString(5, cdAlbum.getTracks());
}
if(album instanceof DVDAlbum) {
    pstmt.setString(1, "DVD");
    DVDAlbum dvdAlbum = (DVDAlbum)album;
    pstmt.setString(4, dvdAlbum.getDirector());
    pstmt.setString(5, dvdAlbum.getPlotOutline());
}
pstmt.setString(2, album.getTitle());
pstmt.setString(3, album.getGenre());
pstmt.executeUpdate();