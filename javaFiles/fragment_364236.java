private SayHiModel model;
private SayHiView  view;
SayHiController(SayHiModel model, SayHiView  view) {
    this.model = model;
    this.view  = view;
    this.model.setValue(model.INITIAL_VALUE);
    view.totalTextField.setText(model.getValue());
    //... Add listeners to the view.
    view.addMultiplyListener(new MultiplyListener());
    view.addClearListener(new ClearListener());
}