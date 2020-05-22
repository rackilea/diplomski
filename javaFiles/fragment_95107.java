searchView.setOnSearchClickListener(new OnClickListener() {
    private boolean extended = false;

    @Override
    public void onClick(View v) {
        if (!extended) {
        extended = true;
            LayoutParams lp = v.getLayoutParams();
            lp.width = LayoutParams.MATCH_PARENT;
        }
    }
});