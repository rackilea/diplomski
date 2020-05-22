Codec codec = new SLCodec();    
Ontology jmo = JADEManagementOntology.getInstance();
getContentManager().registerLanguage(codec);
getContentManager().registerOntology(jmo);
ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
msg.addReceiver(getAMS());
msg.setLanguage(codec.getName());
msg.setOntology(jmo.getName());
try {
    getContentManager().fillContent(msg, new Action(getAID(), new ShutdownPlatform()));
    send(msg);
}
catch (Exception e) {}