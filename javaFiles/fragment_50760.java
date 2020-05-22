public class PhaseListenerImpl implements PhaseListener {

    public void afterPhase(PhaseEvent event) {
        System.out.println("AFTER: " + event.getPhaseId());
    }

    public void beforePhase(PhaseEvent event) {
        System.out.println("BEFORE: " + event.getPhaseId());
    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}