@UiField Label lbl;
@UiField CheckBox chk;

//put this handler in the constructor
lbl.addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            chk.setValue(!chk.getValue(), true);
            //This will so it will manually operate the checkbox
        }
    });