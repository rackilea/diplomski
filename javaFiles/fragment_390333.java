AjaxButton confirmButton = new AjaxButton("confirmButton", layoutForm) {

@Override
protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
    super.onSubmit(target, form);
    System.out.println("Second");
}
};

confirmButton.add(new AjaxEventBehavior("onclick") {

@Override
protected void onEvent(AjaxRequestTarget target) {
    System.out.println("First");
}
});