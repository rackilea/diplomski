tp = new TestPanel("testPanel") {
    protected void onClicked(AjaxRequestTarget target) {
        target.add(txp);
    }
};
txp = new TextPanel("textPanel");
txp.setOutputMarkupId(true);