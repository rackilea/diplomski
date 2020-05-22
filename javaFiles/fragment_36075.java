List<YourObject> listOfObjects = new ArrayList<YourObject>();
  while(rs.next()){
        int id = rs.getInt(1);
        int A = rs.getInt(2);
        String B= rs.getString(3);
        String C = rs.getString(4);
        YourObject ob = new YourObject (id, A, B, C);
        listOfObjects.add(ob); //now you have the list of objects .. iterate trough it
    }