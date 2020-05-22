public void removeGebruiker(String gebruiker_id) {
    //Some checks here perhaps
    String query;
    query = "delete from gebruiker where gebruiker_ID = " + gebruiker_id;
    dbmanager.insertQuery(query);
}