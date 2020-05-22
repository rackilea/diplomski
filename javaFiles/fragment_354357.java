FormLayout form = new FormLayout();
HorizontalLayout blocDateTime = new HorizontalLayout();

PopupDateField dateField = new PopupDateField();
TextField timeField =  new TextField();
dateField.setRequired(true);
timeField.setRequired(true);
blocDateTime.addComponent(dateField);
blocDateTime.addComponent(timeField);
blocDateTime.setCaption("caption.dateTime");
blocDateTime.addStyleName("customrequired");

form.addComponent(blocDateTime);