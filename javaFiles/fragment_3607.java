assignButton.addListener(new ClickListener(){

    boolean added = false;

    @Override
    public void clicked(InputEvent event, float x, float y)
    {
        if(!added) {
            stage.addActor(assignTable.getAssignTable());
            added = true;
        } else {
            stage.removeActor(assignTable.getAssignTable());
            added = false;
        }
}