public void deletePathsExceptThis(String [] extensions){
    if  (extensions == null || extensions.length == 0)
            return;
    SQLiteDatabase db = getWritableDatabase();
    StringBuilder query = new StringBuilder();
    for (int i = 0; i < extensions.length; i++){
       query.concat(" LOWER(").append(ALL_DOCUMENTS_PATH).append(") NOT LIKE ('");
       query.append(extensions[i].replaceAll("'","''"));
        String ext = i == extensions.length - 1 ? "" : " OR ";
       query.append("')").append(ext);
    }
    db.delete(TABLE_ALL_DOCUMENTS, query.toString(), null);
}