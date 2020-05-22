public String foo(Boolean addWhere){
    String query = "SELECT * FROM tbl";
    if(addWhere != null){
        query += (addWhere? " WHERE true" : " WHERE false");
    }
    return query;
}