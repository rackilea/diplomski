add(new ListView<DataHolder>("list", list) {

    @Override
    protected void populateItem(ListItem<DataHolder> item) {
        DataHolder dh = item.getModelObject();
        item.add(new Label("itemNumber", new PropertyModel<Integer>(dh, "number")));
        Label result = new Label("itemResult", new PropertyModel<String>(dh, "result"));
        result.setOutputMarkupId(true);
        result.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(2)));
        item.add(result);
        Thread thread = new Thread(new Processor(item.getModelObject()));
        thread.start();
    }
});