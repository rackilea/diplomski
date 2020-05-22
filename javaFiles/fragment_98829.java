list.add("Hello");
    list.add("World");
    Interpreter i = new Interpreter();  // Construct an interpreter

    map.put("stringList", list);//in java
    try {
        i.set("map", map); 
        i.set("list", list); 
        System.out.println(i.eval("map.put(\"stringList\", list)"));
    } catch (EvalError e1) {
        e1.printStackTrace();
    }