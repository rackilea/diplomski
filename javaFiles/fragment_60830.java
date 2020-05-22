final TextBox editTb = new TextBox();
    editTb.addStyleName(EDIT_FAV_DELETE_STYLE);
    editTb.setText(favoriteBean.getName());

    Scheduler.get().scheduleDeferred(new ScheduledCommand() {

    @Override
    public void execute() {
     editFavoriteTb.setFocus(true);
     editTb.setCursorPos( favoriteBean.getName().length());
    }
  });