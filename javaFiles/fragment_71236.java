final Model<Boolean> checkboxModel = Model.of(false);
final TextField<String> username = new TextField<String>("username", Model.of("")){
    @Override
    public boolean isEnabled() {
        return !checkboxModel.getObject();
    }
};
//instruct wicket to write an id on the html element so it can replace it via javascript
username.setOutputMarkupId(true);
username.setRequired(true);
//AjaxCheckBox is 'A CheckBox which is updated via ajax when the user changes its value'
final CheckBox chk0 = new AjaxCheckBox("chk", checkboxModel) {
    @Override
    protected void onUpdate(AjaxRequestTarget target) {
        //re-render the username textfield
        target.add(username);
    }
};
add(username, chk0);