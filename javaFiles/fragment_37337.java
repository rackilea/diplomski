ACLMessage msgp = new ACLMessage(ACLMessage.SUBSCRIBE);
    msgp.setContent("subscribe1");
    AID remoteAMSf = new AID("salubhai@192.168.2.9:12349/JADE", AID.ISGUID);
    remoteAMSf.addAddresses("http://192.168.2.9:64505/acc");
    msgp.addReceiver(remoteAMSf);
    send(msgp);