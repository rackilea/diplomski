List<String> list = new ArrayList<String>();

     list.add("a");
     list.add("b");
     list.add("c");
     list.add("c");
     list.add("b");
     list.add("a");
     int size = list.size();
     for(int i = 0; i<size/2; i++)
     {
         if(list.get(i) == list.get(size - 1))
            System.out.println("list is palindrome");

     }