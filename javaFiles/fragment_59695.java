ListIterator<DoubleWritable> lit = IteratorUtils.toListIterator(it);
    System.out.println("Using ListIterator 1st pass");
    while(lit.hasNext())
        System.out.println(lit.next());

    // move the list iterator back to start
    while(lit.hasPrevious())
        lit.previous();

    System.out.println("Using ListIterator 2nd pass");
    while(lit.hasNext())
        System.out.println(lit.next());