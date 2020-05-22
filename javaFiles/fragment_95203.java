Link<Void> link = new Link<Void>("myLink") {

    private String customCSS = null;
    private boolean customEnabled = true;

    public void onClick() {
        if (/* test to determine disabled */) {
            customCSS = "disabled";
            customEnabled = false;
        } else {
            customCSS = null;
            customEnabled = true;
        }
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        if (customCSS != null)
            tag.put("class", customCSS);
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled() && customEnabled;
    }
};