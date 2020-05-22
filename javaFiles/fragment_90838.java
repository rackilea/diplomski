.List<String> list1=new ArrayList<String>();
        list1.add("Shoppinglist-fruit");list1.add("Shoppinglist-drinks");list1.add("Shoppinglist-dinner");
        List<String> list2=new ArrayList<String>();
        list2.add("Shoppinglist-drinks");
        list1.removeAll(list2);
        System.out.println(list1);

//Output:- [Shoppinglist-fruit, Shoppinglist-dinner]