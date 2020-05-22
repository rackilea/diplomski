List<Integer> idList = new ArrayList<Integer>();
//accessing to the database and executing the query...
rs = pst.executeQuery();
while (rs.next()) {
    //store the ids in the list
    idList.add(rs.getInt(1));
}
//close all the resources...
//at the bottom of your method
return idList;