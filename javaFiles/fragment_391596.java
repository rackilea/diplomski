Set a = new HashSet<Integer>();
    Set b = new HashSet<Integer>();
    a.add(1);
    a.add(2);
    a.add(3);

    b.add(3);
    b.add(2);
    b.add(1);
    if(a.containsAll(b) && b.containsAll(a))
    {
        System.out.println("Same elements in both");            
    }
    else
    {
        System.out.println("Not same elements in both");
    }