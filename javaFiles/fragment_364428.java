for (POJOClass1 uniqitm : uniqitms)  //list1
{   
    Map<String,Map<String,String>> aggrdata= new HashMap<String,Map<String,String>>();

    for (POJOClass1 redundantitm : redundantitms) //list2               
    {
        if (redundantitm.getResource().equals(uniqitm.getResource()))   //For all objects matching uniq itm, i push below 2 attributes into a hashmap
        {
            aggrdata.put(redundantitm.getMan(), redundantitm.getData_map());
        }
    }

    uniqitm.setMap2(aggrdata); //aggregated data is pushed into the uniq itm object
    uniqitm.setMap(null);
    uniqitm.setMan(null);
    final.add(uniqitm);         //uniq itm object is added to a new array list to be used outside
}