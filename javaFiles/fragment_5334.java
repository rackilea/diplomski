public static List<Role> getAll(){
    Gson gson = new Gson();
    List<Role> toReturn = new ArrayList<Role>();
    DBCollection coll = Db.databse.getCollection("Roles");
    DBCursor cursor = coll.find();
    try {
        while(cursor.hasNext()) {
            System.out.print(cursor.next());
            Role r = gson.fromJson(cursor.next().toString(),Role.class);
            toReturn.add(r);
        }
    } finally {
        cursor.close();
    }
    return toReturn;
}