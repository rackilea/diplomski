// put all widgets together in some container (you can have a more complex layout)
FlowPanel container = new FlowPanel();
container.add(fileUpload);
container.add(propertyNameList);
container.add(propertyTypeList);
container.add(propertyValueList);

// set the container as the content of the form, so named form widgets will get
// their value sent to the server.
formPanel.setWidget(container);