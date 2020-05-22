if (Ids.size()==1){
    stmt.setInt( 1, Ids.get(0).intValue());
}



if (Ids.size() > 1){
    int temp = Ids.size();
    while (temp >1){
        query.insert(Query.indexOf("?") + 1, ", ?");
        temp-=1;

    }

     stmt = connection.prepareStatement(query.toString());

    for (int i=1 ; i<=Ids.size(); i++){

        stmt.setInt( i, Ids.get(i-1).intValue());
    }
}