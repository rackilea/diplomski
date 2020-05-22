public static void main(String[] args) {             
    List<MyObject> myObjects = new ArrayList<>();
    myObjects.add(new MyObject("fName1", "lname1", "ABC"));
    myObjects.add(new MyObject("fName2", "lname2", "PQR"));
    myObjects.add(new MyObject("fName3", "lname3", "XYZ"));
    myObjects.add(new MyObject("fName4", "lname4", "DEF"));

    Map<String,Integer> map = new HashMap<>();
    map.put("XYZ", 1);
    map.put("PQR", 2);
    map.put("ABC", 3);
    map.put("DEF", 4);

    Comparator<MyObject> sortByCode = (obj1,obj2)->Integer.compare(map.get(obj1.code), map.get(obj2.code));
    System.out.println("Before sorting");
    System.out.println(myObjects);

    System.out.println("After sorting");
    myObjects.sort(sortByCode);
    System.out.println(myObjects);
}