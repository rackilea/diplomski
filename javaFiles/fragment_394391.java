ArrayList<ArrayList<String>> final_arrObject = new ArrayList<ArrayList<String>();
 ArrayList<String> list;
 for(int i=0; i<5; i++){ //demo to add 5 ArrayList<String> to an ArrayList<ArrayList<String>>.
    list = new ArrayList<String>(); //only one arrayList.

     //at each iteration you may change you ArrayList Values.
    list.add("Tiger Nixon");    // adding values to the list.
    list.add("System Architect");
    list.add("Edinburgh");
    list.add("2011\/04\/25");
    list.add("$320,800");
    final_arrObject.add(list);
}

JSONObject obj_finalJSON= new JSONObject();
obj_finalJSON.put("data", final_arrObject);
System.out.println(obj_finalJSON.toString());  //it will print your json as a String.