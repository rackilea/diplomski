public HomePage(final PageParameters parameters) {
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
    final CheckBox chk0 = new CheckBox("chk", checkboxModel);
    chk0.setOutputMarkupId(true);
    updateOnClick(chk0, username);
    add(username, chk0);
}

static void updateOnClick(Component a, final Component b){
    a.add(new AjaxFormComponentUpdatingBehavior("click"){

        @Override
        protected void onUpdate(AjaxRequestTarget target) {
            target.add(b);
        }
    });
}