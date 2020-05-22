public static ArrayList<String> checkStoreItems(String currentStore, 
                       ArrayList<String> stlist) throws ClassNotFoundException, SQLException {
    Connection conn = DBConnection.conn();
    String sql = "select itemId from Store_Items where storeID=(select storeID from StoreMain where locationName=?)";
    Object []values = {currentStore}; 
    ResultSet res = DBHandller.getData(sql, conn, values);
    Set<String> storelist = new HashSet<String>();
    while(res.next()){
          String item = res.getString("itemId");
          storelist.add(item);
   }
    stlist.removeAll(storelist);
    return stlist;
 }