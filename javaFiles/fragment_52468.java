interface ClickListener {
    void onCLick(Long sleepId);
}


class SleepNightListener {
    private ClickListener clickListener;

    public SleepNightListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void onClick(SleepNight night) {
        if (clickListener != null) clickListener.onCLick(night.getNightId());    
    }
}