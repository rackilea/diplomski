Button btnFilter = createFilterButton();
ContextMenu cm = new ContextMenu();
cm.setOpenOnClick(true);
cm.setTarget(btnFilter);
TextField tf = new TextField();
tf.addValueChangeListener(e -> {...});
cm.add(tf);