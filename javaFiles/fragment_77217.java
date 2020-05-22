for (int i = 0; i < lvall.size(); i++)
{
    HashMap<String, String> sampleObjectMap = new HashMap<String, String>();
    sampleObjectMap.put("title", dh.val1(i));
    sampleObjectMap.put("person", dh.pers(i));
    sampleObjectMap.put("priorty", setpriority(String.valueOf(dh.prioirty(i))));
    sampleObjectMap.put("dat", getDate(Long.valueOf(dh.time(i)),"dd/MM/yyyy"));
    sampleArrayList.add(sampleObjectMap);
}