public Step createStep(int position) {
    try {
        final StepFragmentSample step = new StepFragmentSample();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    } catch (Exception e) {
        e.printStackTrace();
        Log.e("/Test", "/Excp due to" + e.toString());
    }
    return null;
}