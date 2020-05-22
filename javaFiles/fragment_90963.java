wb.setBrowserNavigationCallback(new BrowserNavigationCallback() {
    public boolean shouldNavigate(String url) {
        if ((url.indexOf("users/login") != -1)) {
            toolbar.removeAll();
            toolbar.setTitleComponent(new Label("My Form", "Title"));
            toolbar.getComponentForm().revalidate();
        } else {
            //Do nothing, since I've already add the commands I want earlier
        }
        return true;
    }
});