List<List<String>> results = new ArrayList<List<String>>();

while ( rs.next() ) {
    List<String> tempList = new ArrayList<String>();
    tempList.add(rs.getString(1));
    tempList.add(rs.getString(2));
    tempList.add(rs.getString(3));
    tempList.add(rs.getString(4));

    results.add(tempList);
}