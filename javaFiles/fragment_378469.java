BrokerService bs = new BrokerService();
    bs.addConnector("tcp://localhost:61616");
    PolicyMap pm = new PolicyMap();
    PolicyEntry pe = new PolicyEntry();
    pe.setPrioritizedMessages(true);
    pm.setDefaultEntry(pe);
    bs.setDestinationPolicy(pm);
    bs.start();