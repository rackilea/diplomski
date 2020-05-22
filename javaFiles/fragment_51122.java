grid.addComponentColumn(Person -> {
     CheckBox chk = new CheckBox("Chk 2", CheckBox1.getValue());
     // save the registration info to unregister at a later time
     Registration listenerRegistration = CheckBox1.addValueChangeListener(e -> chk.setValue(CheckBox1.getValue()));
     // when the checkbox is detached, remove the listener
     chk.addDetachListener(event -> listenerRegistration.remove());
     return chk;
 }).setCaption("ch2").setId("CH2");