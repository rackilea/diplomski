/* Creating a container, with a property of "name". Item Id is a number, here. Can be anything (unique).
* Alternatively, you could use the IndexedContainer to generate it's own ItemId :
* cityContainer.getItem(cityContainer.addItem()).getItemProperty("name").setValue("New York");
*/
IndexedContainer cityContainer = new IndexedContainer();
cityContainer.addContainerProperty("name", String.class, null);
cityContainer.addItem(1).getItemProperty("name").setValue("New York");
cityContainer.addItem(2).getItemProperty("name").setValue("Turku");
cityContainer.addItem(3).getItemProperty("name").setValue("Paris");
cityContainer.addItem(4).getItemProperty("name").setValue("Zanzibar");
cityContainer.addItem(5).getItemProperty("name").setValue("Turin");
cityContainer.addItem(6).getItemProperty("name").setValue("London");
cityContainer.getItem(cityContainer.addItem()).getItemProperty("name").setValue("New York");
/* Lets sort the container on ascending name*/
cityContainer.sort(new Object[]{"name"}, new boolean[]{true});

/* Here's a comboBox that uses that container, where we are using the "name" property as the item caption */
ComboBox comboBox = new ComboBox("City", cityContainer);
comboBox.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);
comboBox.setItemCaptionPropertyId("name");