@Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
public void onEvent(Message message) {
    Message stickyEvent = EventBus.getDefault().getStickyEvent(Message.class);
    if(stickyEvent != null) {
        tv.setText(message.getMessage());
        EventBus.getDefault().removeStickyEvent(stickyEvent);
    }
};