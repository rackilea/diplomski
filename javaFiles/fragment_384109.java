holder.btn_loc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // This should be optional for your case
        // but it can be useful if you're ever in a situation
        // where the callback isn't always available
        if(mAdapterCallback != null){
            mAdapterCallback.onMethodCallback(user.getUser_info());
        }
    }
});