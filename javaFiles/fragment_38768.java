//somewhere in the class create model variable:
boolean checkBoxValue = true;

//this is your hideable component
Label someComponent;

...
//and add PropertyModel for checkbox:
AjaxCheckBox checkBox = new AjaxCheckBox("checkBox", new PropertyModel(this, "checkBoxValue")) {
        @Override
        protected void onUpdate(AjaxRequestTarget target) {
                //if checkbox is checked, then our component is shown
                someComponent.setVisible(checkBoxValue);
                target.add(someComponent);
        }
};

...
//this is your component to update
someComponent = new Label("someComponent", "some text");

//this method allows you to hide/show component with ajax updates.
someComponent.setOutputMarkupPlaceholderTag ( true );