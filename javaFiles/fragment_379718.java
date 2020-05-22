HashMap<String, MyBO> myObjs = MyData.getMyData();
    String  id = "ABC";
    if(myObjs.containsKey(id)){
        System.out.println("Matched key = " + id);
    } else{
        System.out.println("Key not matched with ID");
    }