//1
    StartState startState = new StartState();
    startState.setName("start");
    System.out.println("Start State is = "+startState);
    //2
    Node firstNode = new Node();
    firstNode.setName("firstNode");
    System.out.println("First Node is = "+firstNode);
    //3
    State firstState = new State();
    firstState.setName("firstState");
    System.out.println("First State is = "+ firstState);
    //4
    Node secondNode = new Node();
    secondNode.setName("secondNode");
    System.out.println("Second Node is = "+secondNode);
    //5
    EndState endState = new EndState();
    endState.setName("end");
    System.out.println("End State is = "+endState);
    // Transition from 1st to 2nd
    Transition t1 = new Transition();
    t1.setName("to_firstNode");
    t1.setFrom(startState);
    t1.setTo(firstNode);
    System.out.println("Transition t1 = "+t1.toString());
    // Transition from 2nd to 3rd
    Transition t2 = new Transition();
    t2.setName("to_firstState");
    t2.setFrom(firstNode);
    t2.setTo(firstState);
    System.out.println("Transition t2 = "+t2.toString());
    // Transition from 3rd to 4th
    Transition t3 = new Transition();
    t3.setName("to_secondNode");
    t3.setFrom(firstState);
    t3.setTo(secondNode);
    System.out.println("Transition t3 = "+t3.toString());
    // Transition from 4th to 5th
    Transition t4 = new Transition();
    t4.setName("to_end");
    t4.setFrom(secondNode);
    t4.setTo(endState);
    System.out.println("Transition t4 = "+t4.toString());
    // Create New Process Definition
    ProcessDefinition newProcessDefinition = new ProcessDefinition();

            // Set Name for Process Definition
            newProcessDefinition.setName("CoolProcess");

            // Adding Nodes to Process Definition
            newProcessDefinition.setStartState(startState);
            newProcessDefinition.addNode(firstNode);
            newProcessDefinition.addNode(firstState);
            newProcessDefinition.addNode(secondNode);
            newProcessDefinition.addNode(endState);

            // Adding Transitions to Process Definition  
            firstNode.addArrivingTransition(t1);
            firstNode.addLeavingTransition(t2);
            firstState.addArrivingTransition(t2);
            firstState.addLeavingTransition(t3);
            secondNode.addArrivingTransition(t3);
            secondNode.addLeavingTransition(t4);
            endState.addArrivingTransition(t4);

            JbpmContext jbpmContext = jbpmconfig.createJbpmContext();

            //Deploy the Created Process Definition to Database
            jbpmContext.deployProcessDefinition(newProcessDefinition);