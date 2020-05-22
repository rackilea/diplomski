@Override
protected void onInitialize() {
super.onInitialize();

Form<Contract> form = new Form("formContact", new CompoundPropertyModel(getModel()){
    @Override
    protected void onSubmit() {
        super.onSubmit();
        service.save(getModelObject());
    }
});
add(form);
form.add(new TextField<>("name").setRequired(true));
form.add(new TextField<>("surname").setRequired(true));
form.add(new TextField<>("mobile").setRequired(true));
form.add(new TextField<>("phone").setRequired(false));
form.add(new HiddenField<>("id"));
form.add(new EmailTextField("email").setRequired(false));