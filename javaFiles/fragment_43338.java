public class YourActivity{
    //declare your switch

    @Override
    public void onCreate() {
        setContentView(R.layout.layout_main_activity);
        //initialize your switch
    }

    @Override
     public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)  
    public void onMessageEvent(SwitchEvent event) {
        //update your switch element
    }
}