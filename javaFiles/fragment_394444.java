LinkedList i=a; //a contains the nodes which are adjacent to the last element of g
   for(String i1: i )
   {
      if(g.contains(i1) || i1.equals("o"))
       { continue; }
      g.addLast(i1);
      func(g);
      g.removeLast();
   }