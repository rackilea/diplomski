public class MyPhaseListener implements PhaseListener {

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // Do your job here which should run right before the RESTORE_VIEW phase.
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        // Do your job here which should run right after the RESTORE_VIEW phase.
    }

}