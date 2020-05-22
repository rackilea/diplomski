private OnRebindCallback<ActivityMainBinding> delayRebindCallback = 
        new OnRebindCallback<ActivityMainBinding>() {
    @Override
    public boolean onPreBind(ActivityMainBinding binding) {
        return false;
    }
};

// ... and then after creating the binding ...
binding.addOnRebindCallback(delayRebindCallback);