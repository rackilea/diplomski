ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
...
msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
msg.setOntology(YourOntology.NAME);
...
try {
    agent.getContentManager().fillContent(msg, parameterConcept);
} catch (Exception e) {
     throw new RuntimeException("cannot fill message.", e);
}