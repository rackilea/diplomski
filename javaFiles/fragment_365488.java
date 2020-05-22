rs = ps.executeQuery();
// retrieve records from database here
if(rs.next()) {
    idPicture = rs.getInt(1); // here 1 is column index of column pictureId
    longitude = rs.getString(2); // here 2 is column index of string longitude
    latitude = rs.getString(3);
    status = rs.getInt(4);
    path = rs.getString(5);
    timestamp = rs.getTimestamp(6);
    pic = new Pictures(idPicture, longitude, latitude, status, path, timestamp);
} else {
    // there is no record with id 1.
}