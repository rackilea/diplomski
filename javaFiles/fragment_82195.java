Map<Integer, List<classObject>> hashMap = new HashMap<Integer, List<classObject>>();
    for(int i=0; i<arraylist.size(); i++)
    {
        sortID = arraylist.get(i).getID();
        List<classObject> objectList = hashMap.get(sortID);
        if(objectList == null)
        {
            objectList = new ArrayList<>();
        }
        objectList.add(arraylist.get(i));
        hashMap.put(sortID, objectList);
    }