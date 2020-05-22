List list1 = getListOneFromDatabase();
List list2 = getListTwoFromDatabase();
List list3 = getListThreeFromDatabase();
// and so on ...

Map<String, List> requestListMap = new HashMap<String, List>();
requestListMap.put("list1", list1);
requestListMap.put("list2", list2);
requestListMap.put("list3", list3);
// and so on ...

request.setAttribute("reqListMap", requestListMap);