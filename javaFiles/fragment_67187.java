List<String> list = 
         Collections.synchronizedList(new ArrayList<String>());

       //Adding elements to synchronized ArrayList
       list.add("Item1");
       list.add("Item2");
       list.add("Item3");