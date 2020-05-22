Queue<String> testQueue = new LinkedList<String>();

    testQueue.add("first");
    testQueue.add("understand");
    testQueue.add("problem");
    testQueue.add("then Ask");
    String fristValue = testQueue.poll();

    //Use your value;
    System.out.println(fristValue);

        //After you are done using it, resubmit it to the Queue
    testQueue.add(fristValue); 

    String secondValue = testQueue.poll();

    //same way....
    System.out.println(secondValue);