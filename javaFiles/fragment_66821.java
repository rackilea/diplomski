MyCustomAction mca = new MyCustomAction();//MyCustomAction extends org.apache.commons.scxml.model.Action
MyCustomAction2 mca2 = new MyCustomAction2();//MyCustomAction2 extends org.apache.commons.scxml.model.Action
State state = (State) getEngine().getStateMachine().getTargets().get("yourstate");
OnEntry oe = state.getOnEntry();
oe.addAction(mca);
oe.addAction(mca2);
state.setOnEntry(oe);