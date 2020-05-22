binding.addOnRebindCallback(new OnRebindCallback() {
    @Override
    public boolean onPreBind(ViewDataBinding binding) {
        TransitionManager.beginDelayedTransition(
                (ViewGroup)binding.getRoot());
        return super.onPreBind(binding);
    }
});