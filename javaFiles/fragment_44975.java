ksession = kbase.newStatefulKnowledgeSession();
AgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
ksession.addEventListener(agendaEventListener);
//...
ksession.fireAllRules();
//...
List<Activation> activations = agendaEventListener.getActivationList();