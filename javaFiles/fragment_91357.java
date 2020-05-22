HashMap<Integer, Map<String, String>> custMap = new HashMap<Integer, Map<String, String>>();

for (int i = 0; i < 10; i++) {
    Map<String, String> mapCust = new HashMap<String, String>(); // move this line inside the loop
    mapCust.put("fname", fname);
    mapCust.put("lname", lname);
    mapCust.put("phone1", phone1);
    mapCust.put("phone2", phone2);

    custMap.put(i, mapCust);
}