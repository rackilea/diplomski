String name = "Alice" ;
AID alice = new AID( name, AID.ISLOCALNAME );

AgentContainer c = getContainerController();

        try {
            AgentController a = c.createNewAgent(name,"com.sender.Receiver", null);
            a.start();
            System.out.println(alice.getLocalName() + " Created");
        }catch (Exception e){
            e.printStackTrace();
        }