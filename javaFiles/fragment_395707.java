MysteryClass.mystery(2);
    if (2 > 0) (true) ---> mystery(2-1);
    |   if(1 > 0) (true) ---> mystery (1-1); // Action (A)
    |   |   if(0 > 0) (false) ---> // do nothing 
    |   |     
    |   System.out.println(1 * 4);
    |   mystery(1-1);
    |
    System.out.println(2 * 4);
    mystery(2-1); ---> // repeat action (A)