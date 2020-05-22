HashMap<String, String> myObjs =new HashMap<>();
    myObjs.put("ABC","a");
    myObjs.put("AC","a");
    String  id = "ABC";
    if(myObjs.containsKey(id)){
        System.out.println("Matched key = " + id);
    } else{
        System.out.println("Key not matched with ID");
    }