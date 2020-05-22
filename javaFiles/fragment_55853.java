private String pictureTable() {
    return "CREATE TABLE geophoto_db_pictures ( picid integer,"
            + "name varying character(50),"
            + "city varying character(20) NOT NULL,"
            + "zipcode varying character(20) NOT NULL,"
            + "country varying character(20) NOT NULL,"
            + "picdate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,"
            + "tags varying character(200),"
            + "image varying character(200) NOT NULL,"
            + "uploaded integer NOT NULL DEFAULT 0, PRIMARY KEY (picid));";
}