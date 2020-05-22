add(new AjaxLazyLoadPanel("table") {

    @Override
    public Component getLazyLoadComponent(String markupId) {
        return new MyLongLoadingTable(markupId);
    }
});