Stack<Stack<Integer>> stacks = new Stack<>();
    // Previous example
    // ...
    //straight Comparator
    Comparator<Stack<Integer>> byFirst = Comparator.comparingInt(Stack::firstElement);
    //reverse Comparator
    Comparator<Stack<Integer>> reverseByFirst 
           = (Stack<Integer> s1, Stack<Integer> s2)
                                   -> s2.firstElement().compareTo(s1.firstElement());
    // or  = (Stack<Integer> s1, Stack<Integer> s2)-> s2.get(0).compareTo(s1.get(0));

    // get Stack
    stacks = Stream.of(stackI1,stackI2,stackI3)
    //          .sorted(byFirst)       // byFirst
              .sorted(reverseByFirst)  // reverse
              .collect(Collector.of(
                           () -> new Stack(),
                           (s,b)->s.push(b),
                           (b1, b2) -> (Stack) b1.push(b2)
                       )
                  );
    System.out.println(stacks); //[[7, 8, 9], [4, 5, 6], [1, 2, 3]]