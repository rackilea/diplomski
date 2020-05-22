public ArrayList getMarkerID(int objectId){
     ArrayList<int> myArrayList = new ArrayList<>();
     myResultSet.beforeFirst();
     while (myResultSet.next()){
         if (myResultSet.getInt("object_id") == objectId){
              myArrayList.add(myResultSet.getInt("marker_id"));
         }
      }
      return myArrayList;
  }