List<MyClass> pairList = new ArrayList<>();

    //assuming key and value are of type String 
    //repeat the following 4 lines as much as needed
    MyClass myClass = new MyClass();
    myClass.setKey("...");
    myClass.setValue("...");
    pairList.add(myClass); 

    //Create an Map as you model and add pairList to it
    Map<String, List<MyClass>> model = new HashMap<>();
    model.put('pair_list', pairList);

    //Now you can add it to request for passing it to JSP/JSTL
    request.setAttribute('model', model);