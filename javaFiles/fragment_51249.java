Map<Object, Object> map=messageservice.getReportees(id);
Set<Map.Entry<Object,Object> s1=map.entrySet();
for (Iterator<Map.Entry<Object,Object> iterator = s1.iterator(); iterator.hasNext();)  {
    Map.Entry<Object,Object> entry = iterator.next();
    Object name = entry.getKey();
    Object value = entry.getValue();
    ...
}