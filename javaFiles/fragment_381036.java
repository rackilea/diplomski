Map<String, Integer> numberOfInstanceMap = new HashMap<String, Integer>(); //temporary placeholder

for (Map.Entry<CompositeKeyBean, ReportDataBean> entry : list.entrySet())
{
    String idvalue = entry.getKey().getCompositeKeyList().get(0);
    if(!numberOfInstanceMap.containsKey(idvalue)) {
        numberOfInstanceMap.put(idvalue, 1); //initialize the key to 1
    } else {
        numberOfInstanceMap.replace(idValue, numberOfInstanceMap.get(idValue) + 1); //add 1 to the existing value of the key
    }
}

for (Map.Entry<CompositeKeyBean, ReportDataBean> entry : list.entrySet())
{
    String idvalue = entry.getKey().getCompositeKeyList().get(0);
    Integer i = numberOfInstanceMap.get(idValue);
    if(i>1) { //remove duplicate if the key exists more than once
        list.remove(idValue);
    }        
}